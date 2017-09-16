package com.tuyendev.common;

import com.tuyendev.fw.DataUtil;

import javax.faces.context.FacesContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void setCookie(FacesContext facesContext, String name, String value, int expiry) {

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        Cookie oldCookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equalsIgnoreCase(name)) {
                    oldCookie = userCookies[i];
                    break;
                }
            }
        }

        if (oldCookie != null) {
            // delete old cookie
            oldCookie.setValue(value);
            oldCookie.setMaxAge(0);
            response.addCookie(oldCookie);
        }
        //create new cookie
        Cookie newCookie = new Cookie(name, value);
        newCookie.setMaxAge(expiry);
        newCookie.setHttpOnly(true);
        newCookie.setPath(request.getContextPath());
        response.addCookie(newCookie);

    }

    public static Cookie getCookie(FacesContext facesContext, String name) {

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    return cookie;
                }
            }
        }
        return null;
    }

    public static String getLanguageCookie(FacesContext ctx) {
        Cookie cookie = getCookie(ctx, Lang.DEFAULT_LANGUAGE.getCode());
        return DataUtil.isNullObject(cookie) ? Lang.VIETNAM.getCode() : cookie.getValue();
    }

}
