package com.tuyendev.common;

import com.tuyendev.fw.DataUtil;

import java.util.Locale;

import java.util.Objects;

import javax.faces.context.FacesContext;

public class LocaleUtil {
    
    public static void setLocale(FacesContext ctx) {
        String language = CookieUtil.getLanguageCookie(ctx);
        Locale current = getCurrentLocale(ctx);
        if (!Objects.equals(current.getLanguage(), language)) {
            ctx.getViewRoot().setLocale(new Locale(language));
        }
    }

    public static Locale getCurrentLocale(FacesContext ctx) {
        Locale browserLocale = ctx.getExternalContext().getRequestLocale();
        Locale current = ctx.getViewRoot().getLocale();
        return DataUtil.isNullObject(current) ? browserLocale : current;
    }
}
