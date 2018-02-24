package com.tuyendev.controller;

import com.google.common.collect.Maps;

import com.tuyendev.common.Constant;
import com.tuyendev.common.JSFUtil;
import com.tuyendev.common.Lang;

import com.tuyendev.common.LocaleUtil;
import com.tuyendev.component.ExtendedPopupHandler;
import com.tuyendev.exception.LogicException;

import com.tuyendev.fw.DataUtil;

import com.tuyendev.messenger.Messenger;

import java.awt.event.ActionEvent;

import java.io.Serializable;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import one.util.streamex.StreamEx;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.javatools.resourcebundle.BundleFactory;

import org.apache.myfaces.trinidad.event.RangeChangeEvent;
import org.apache.myfaces.trinidad.util.ComponentReference;

public class BaseController implements Serializable {

    protected final static ADFLogger baseLogger = ADFLogger.createADFLogger(BaseController.class);
    private Map<String, ResourceBundle> mapBundleResources = getMultiBundle();
    private final ExtendedPopupHandler extendPopupHandler=  getExtendedPopupHandler();
    
    private ExtendedPopupHandler getExtendedPopupHandler(){
        return (ExtendedPopupHandler)JSFUtil.getManagedBeanValue("extendedPopup");   
    }


    public Map<String, ResourceBundle> getMultiBundle() {
        Map<String, ResourceBundle> mlrs = Maps.newHashMap();
        mlrs.put(Lang.VIETNAM.getCode(),
                 BundleFactory.getBundle("com.tuyendev.resources.lang", new Locale(Lang.VIETNAM.getCode())));
        mlrs.put(Lang.ENGLISH.getCode(),
                 BundleFactory.getBundle("com.tuyendev.resources.lang", new Locale(Lang.ENGLISH.getCode())));
        return mlrs;
    }


    public void reportSuccess(String key, Object... params) {
        Messenger.sendSuccessMessage(getText(key, params));
    }

    public void reportWarm(String keyMess, Object... params) {
        Messenger.sendWarningMessage(getText(keyMess, params));
    }

    private void reportWarm(LogicException e, ADFLogger logger) {
        try {
            Object[] params = e.getParams();
            String errorMes = getText(e.getKeyMsg(), params);
            reportWarm(errorMes);
            logger.severe(errorMes);
        } catch (Exception ex) {
            baseLogger.severe(ex);
        }
    }

    private void reportError(LogicException e, ADFLogger logger) {
        try {
            Object[] params = e.getParams();
            String errorMes = getText(e.getKeyMsg(), params);
            Messenger.sendErrorMessage(errorMes);
            logger.severe(errorMes);
        } catch (Exception ex) {
            baseLogger.severe(ex);
        }
    }
    
    public void refreshPage(FacesContext fc) {
        String refreshpage = fc.getViewRoot().getViewId();
        JSFUtil.redirectUrl(refreshpage.replaceAll("/", "") + "?faces-redirect=true");
    }

    public void reportError(Exception e) {
        reportError(e, baseLogger);
    }

    public void reportError(Exception e, ADFLogger logger) {
        try {
            if (e instanceof LogicException) {
                LogicException ex = (LogicException) e;
                if (Objects.equals(ex.getErrCode(), Constant.ERROR_CODE.RUNTIME) ||
                    Objects.equals(ex.getErrCode(), Constant.ERROR_CODE.LOGIC) ||
                    Objects.equals(ex.getErrCode(), Constant.ERROR_CODE.UNKNOWN)) {
                    reportError(ex, logger);
                } else if (DataUtil.isNullOrEmpty(ex.getErrCode()) ||
                           Objects.equals(ex.getErrCode(), Constant.ERROR_CODE.VALIDATE)) {
                    reportWarm(ex, logger);
                }
            } else if (e instanceof Exception) {
                Messenger.sendErrorMessage(getText("com.tuyendev.common.message.error.system"));
                logger.severe(e);
            }
        } catch (Exception es) {
            baseLogger.severe(es);
        }

    }

    public void reportError(String keyMess, Object... params) {
        Messenger.sendErrorMessage(getText(keyMess, params));
    }

    public void refreshTable(UIComponent table) {
        RangeChangeEvent event = new RangeChangeEvent(table, 0, 0, 0, 0);
        table.broadcast(event);
        AdfFacesContext.getCurrentInstance().addPartialTarget(table);
    }
    
    public void openPopup(ComponentReference popup) {
        JSFUtil.showPopup(popup.getComponent());
    }
    
    
    public void closePopup(ComponentReference popup) {
        JSFUtil.hidePopup(popup.getComponent());
    }
    
    
    public void openExtendedPopup(ComponentReference popup){
        openExtendedPopup(((RichPopup) popup.getComponent()));
    }
    
    public void openExtendedPopup(RichPopup popup) {
        extendPopupHandler.onOpen(popup);
    }


    public Locale getCurrentLocale() {
        return LocaleUtil.getCurrentLocale(FacesContext.getCurrentInstance());
    }


    public String getText(String key, Object... params) {
        try {
            //checking resource
            ResourceBundle rs = mapBundleResources.get(getCurrentLocale().getLanguage());

            //get Key
            String message = rs.getString(key);
            String[] values = null;
            if (!DataUtil.isNullOrEmpty(params)) {
                values = StreamEx.of(params)
                                 .map(Object::toString)
                                 .toArray(String.class);
            }
            if (!DataUtil.isNullOrEmpty(values) && !DataUtil.isNullOrEmpty(message)) {
                message = MessageFormat.format(message, values);
            }
            return DataUtil.isNullOrEmpty(message) ? key : message;
        } catch (Exception e) {
            baseLogger.severe(e);
        }
        return key;
    }


}
