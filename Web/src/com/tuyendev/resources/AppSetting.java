package com.tuyendev.resources;

import java.util.Locale;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class AppSetting {
    
    private final static ResourceBundle bundle = getBundleAppSetting();
        
    public static ResourceBundle getBundleAppSetting(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String messageBundleName = facesContext.getApplication().getMessageBundle();
        return ResourceBundle.getBundle(messageBundleName);    
    }
    
    
}
