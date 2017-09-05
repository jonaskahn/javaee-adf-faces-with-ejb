package com.tuyendev.setting;

import com.tuyendev.common.CookieUtil;
import com.tuyendev.common.LocaleUtil;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import oracle.adf.controller.v2.lifecycle.Lifecycle;
import oracle.adf.controller.v2.lifecycle.PagePhaseEvent;
import oracle.adf.controller.v2.lifecycle.PagePhaseListener;

public class PrePageLoadedSetting implements PagePhaseListener {

    public void afterPhase(PagePhaseEvent pagePhaseEvent) {
        if (pagePhaseEvent.getPhaseId() == Lifecycle.PREPARE_RENDER_ID) {
            LocaleUtil.setLocale(FacesContext.getCurrentInstance());
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
                                                                          .getExternalContext()
                                                                          .getRequest();
            FacesContext fc = FacesContext.getCurrentInstance();
            String currentPage = fc.getViewRoot()
                                   .getViewId()
                                   .replaceAll("/", "");
            CookieUtil.setCookie(fc, "CURRENT_PAGE", currentPage, 60 * 60 * 60); //1h expired
        }
    }

    @Override
    public void beforePhase(PagePhaseEvent pagePhaseEvent) {
    }
}
