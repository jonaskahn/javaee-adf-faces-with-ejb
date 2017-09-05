package com.tuyendev.setting;

import com.tuyendev.common.CookieUtil;
import com.tuyendev.common.JSFUtil;
import com.tuyendev.common.Lang;

import com.tuyendev.fw.DataUtil;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.Cookie;

public class LanguageSetting implements Serializable {

    @SuppressWarnings("compatibility:9151126823632763920")
    private static final long serialVersionUID = 3848022905456551129L;

    private String language;

    @PostConstruct
    public void init() {
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            Cookie cookie = CookieUtil.getCookie(ctx, Lang.DEFAULT_LANGUAGE.getCode());
            language = DataUtil.isNullObject(cookie) ? Lang.VIETNAM.getCode() : cookie.getValue();

        } catch (Exception e) {
            language = Lang.VIETNAM.getCode();
        }
    }

    public void localeChangeListener(ValueChangeEvent valueChangeEvent) {
        this.language = valueChangeEvent.getNewValue().toString();
        doChangeLanguage(this.language);
    }

    public void doChangeLanguage(String code) {
        FacesContext cfx = FacesContext.getCurrentInstance();
        CookieUtil.setCookie(cfx, Lang.DEFAULT_LANGUAGE.getCode(), code,
                              60 * 60 * 24 * 365 * 5); // expired in 5 years
        refreshPage(cfx);
    }

    private void refreshPage(FacesContext fc) {
        String refreshpage = fc.getViewRoot().getViewId();
        JSFUtil.redirectUrl(refreshpage.replaceAll("/", "")+"?faces-redirect=true");
    }


    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
