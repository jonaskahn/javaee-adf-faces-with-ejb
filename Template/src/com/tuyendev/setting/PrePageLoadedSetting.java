package com.tuyendev.setting;

import com.tuyendev.common.Constant;
import com.tuyendev.common.CookieUtil;
import com.tuyendev.common.LocaleUtil;

import java.lang.reflect.Method;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

import org.apache.myfaces.trinidad.context.RequestContext;

public class PrePageLoadedSetting implements PagePhaseListener {

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
            LocaleUtil.setLocale(FacesContext.getCurrentInstance());
            FacesContext fc = FacesContext.getCurrentInstance();
            String currentPage = fc.getViewRoot()
                                   .getViewId()
                                   .replaceAll("/", "");
            CookieUtil.setCookie(fc, Constant.CURRENT_PAGE, currentPage, 60 * 60 * 60); //It will be expired after one hour
            CookieUtil.setCookie(fc, Constant.SUB_MENU_ID, currentPage, 60 * 60 * 60 * 24); //It will be expired after one day
        }
    }
    
    @Override
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
    }
}
