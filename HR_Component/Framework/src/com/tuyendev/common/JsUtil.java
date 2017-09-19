package com.tuyendev.common;

import javax.faces.context.FacesContext;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class JsUtil {
    
    public static void showModal(String modalId){
        String script = "$(\"#"+modalId+"\").modal({                    // wire up the actual modal functionality and show the dialog\n" + 
        "      \"backdrop\"  : \"static\",\n" + 
        "      \"keyboard\"  : true,\n" + 
        "      \"show\"      : true                     // ensure the modal is shown immediately\n" + 
        "    });";
        callJS(script);
    }
    
    public static void hideModal(String modalId){
        StringBuilder script = new StringBuilder()
            .append("$(\"#"+modalId+"\").modal(\"hide\")");
        callJS(script.toString());
    }
    
    public static void callJS(String script){
        ExtendedRenderKitService erks =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(FacesContext.getCurrentInstance(), script);    
    }
    
}
