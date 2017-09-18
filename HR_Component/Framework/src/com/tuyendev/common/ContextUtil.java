package com.tuyendev.common;

import java.util.Hashtable;

import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextUtil {
    @SuppressWarnings("unchecked")
    public static Context getRemoteContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, Constant.PROVIDER_URL);
        return new InitialContext(env);
    }

    public static Context getLocalContext() throws Exception {
        return new InitialContext();
    }
}
