package com.tuyendev.inject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.common.collect.Lists;

import java.util.Objects;

import javax.el.ELContext;
import javax.el.MapELResolver;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import oracle.adf.controller.metadata.model.beans.ManagedBean;
import oracle.adf.controller.metadata.model.beans.ManagedBeanScopeType;

/* Illegal internal package import. Please use public API */
import oracle.adf.share.logging.ADFLogger;

import oracle.adfinternal.controller.beans.AnnotationUtils;
import oracle.adfinternal.controller.beans.ManagedBeanFactory;
import oracle.adfinternal.controller.state.ScopeMap;

/**
 * Create by tuyendev
 */
public class ELResolverWithInjectEJB extends MapELResolver {

    private static final ADFLogger logger = ADFLogger.createADFLogger(ELResolverWithInjectEJB.class);

    private static Method getManagedBeanScopeType = null;
    private static Method shouldIncludeHigherScopes = null;
    private static Method newInstance = null;
    static {
        try {
            getManagedBeanScopeType = ScopeMap.class.getDeclaredMethod("getManagedBeanScopeType", null);
            getManagedBeanScopeType.setAccessible(true);
            shouldIncludeHigherScopes = ScopeMap.class.getDeclaredMethod("shouldIncludeHigherScopes", null);
            shouldIncludeHigherScopes.setAccessible(true);
            newInstance = ManagedBeanFactory.class.getDeclaredMethod("newInstance", ManagedBean.class);
            newInstance.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ELResolverWithInjectEJB() {
        super();
    }

    @Override
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public Object getValue(ELContext elContext, Object base, Object var) {
        ScopeMap scope = (ScopeMap) (base instanceof ScopeMap ? base : null);
        if (scope == null || scope.containsKey(var))
            return super.getValue(elContext, base, var);
        Object bean = null;
        try {
            ManagedBeanFactory mbf = ManagedBeanFactory.getInstance();
            ManagedBean managedBean = mbf.getManagedBeanInCurrentPageFlow((String) var);
            ManagedBeanScopeType expectedScope = (ManagedBeanScopeType) getManagedBeanScopeType.invoke(scope, null);
            if (((Boolean) shouldIncludeHigherScopes.invoke(scope, null)) &&
                (managedBean == null || !managedBean.getScope().equals(expectedScope))) {
                managedBean = mbf.getManagedBeanInAdfPageFlow((String) var);
            }
            if (managedBean != null && managedBean.getScope().equals(expectedScope)) {
                bean = newInstance.invoke(mbf, managedBean);
                if (bean != null) {
                    scope.put((String) var, bean);
                    EJBInjector.inject(bean);
                    AnnotationUtils.runPostConstructIfSpecified(bean, managedBean.getName(), managedBean.getScope());
                    elContext.setPropertyResolved(true);
                }
            }
        } catch (Exception e) {
            logger.severe(e);
        }
        return bean;
    }

    static class EJBInjector {
        private static Map<String, List> processed = Maps.newHashMap();
        private static Context remoteCTX = null;
        private static Context localCTX = null;
        static {
            try {
                remoteCTX = getRemoteContext();
                localCTX = getLocalContext();
            } catch (Exception e) {
                logger.severe(e);
            }
        }

        private static List<Field> getAllFieldInClass(Class c) throws Exception {
            List<Field> fields = Lists.newArrayList(c.getDeclaredFields());
            if (c.getSuperclass() == null)
                return Lists.newArrayList();
            else
                fields.addAll(getAllFieldInClass(c.getSuperclass()));
            return fields;
        }

        @SuppressWarnings("unchecked")
        public static void inject(Object o) throws Exception {
            List<Field> inj = null;
            if (!processed.containsKey(o.getClass().getName())) {
                inj = Lists.newArrayList();
                List<Field> fields = getAllFieldInClass(o.getClass());
                for (Field field : fields) {
                    if (field.getAnnotation(Autoinjector.class) != null) {
                        field.setAccessible(true);
                        inj.add(field);
                    }
                }
                processed.put(o.getClass().getName(), inj.isEmpty() ? null : inj);
            }
            inj = inj != null ? inj : processed.get(o.getClass().getName());
            if (inj != null) {
                for (Field f : inj) {
                    String injectType = f.getAnnotation(Autoinjector.class).injectType();
                    String mappedName = f.getAnnotation(Autoinjector.class).mappedName();
                    String refName = f.getAnnotation(Autoinjector.class).refName();
                    if (Objects.equals(injectType, InjectorType.REMOTE)) {
                        f.set(o, remoteCTX.lookup(mappedName + "#" + f.getType().getName()));

                    } else if (Objects.equals(injectType, InjectorType.LOCAL)) {
                        f.set(o, localCTX.lookup("java:comp/env/" + refName));
                    }
                }
            }
        }

        @SuppressWarnings("unchecked")
        public static Context getRemoteContext() throws NamingException {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
            //NOTE: change your server and port here
            env.put(Context.PROVIDER_URL, "t3://127.0.0.1:7101");
            return new InitialContext(env);
        }

        public static Context getLocalContext() throws Exception {
            return new InitialContext();
        }
    }
}
