package com.tuyendev.messagesender;

import com.tuyendev.common.Constant;

import javax.faces.context.FacesContext;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

/**
 * @create by tuyendev
 */
public class MessageSender {
    
    
    public static void sendSuccessMessage(String message) {
        sendMessage(MessageSenderType.SUCCESS.getType(),"SUCCESS", message, Constant.DEFAULT_TIMEOUT_MESSAGE.SUCCESS);
    }
    
    public static void sendInfoMessage(String message) {
        sendMessage(MessageSenderType.INFO.getType(),"INFO", message, Constant.DEFAULT_TIMEOUT_MESSAGE.INFO);
    }
    
    public static void sendWarningMessage(String message) {
        sendMessage(MessageSenderType.WARNING.getType(),"WARNING", message, Constant.DEFAULT_TIMEOUT_MESSAGE.WARNING);
    }
    
    public static void sendErrorMessage(String message) {
        sendMessage(MessageSenderType.ERROR.getType(),"ERROR", message, Constant.DEFAULT_TIMEOUT_MESSAGE.ERROR);
    }
    
    public static void sendSuccessMessage(String title, String message) {
        sendMessage(MessageSenderType.SUCCESS.getType(),title, message, Constant.DEFAULT_TIMEOUT_MESSAGE.SUCCESS);
    }
    
    public static void sendSuccessMessage(String title, String message,long timeout) {
        sendMessage(MessageSenderType.SUCCESS.getType(),title, message, timeout);
    }
    
    public static void sendInfoMessage(String title, String message) {
        sendMessage(MessageSenderType.INFO.getType(),title, message, Constant.DEFAULT_TIMEOUT_MESSAGE.INFO);
    }
    
    public static void sendInfoMessage(String title, String message,long timeout) {
        sendMessage(MessageSenderType.INFO.getType(),title, message, timeout);
    }
    
    public static void sendWarningMessage(String title, String message) {
        sendMessage(MessageSenderType.WARNING.getType(),title, message, Constant.DEFAULT_TIMEOUT_MESSAGE.WARNING);
    }
    
    public static void sendWarningMessage(String title, String message,long timeout) {
        sendMessage(MessageSenderType.WARNING.name(),title, message, timeout);
    }
    
    public static void sendErrorMessage(String title, String message) {
        sendMessage(MessageSenderType.ERROR.getType(),title, message, Constant.DEFAULT_TIMEOUT_MESSAGE.ERROR);
    }
    
    public static void sendErrorMessage(String title, String message,long timeout) {
        sendMessage(MessageSenderType.ERROR.getType(),title, message, timeout);
    }
    
    private static void sendMessage(String type, String title, String message,long timeout){
        StringBuffer script = new StringBuffer().append("$.notify({\n" + 
        "	// options\n" + 
        "	title: '" + title + "',\n" + 
        "	message: '" + message + "',\n" + 
        "	target: '_blank'\n" + 
        "    },{\n" );
        script.append("	// settings\n" + 
        "	element: 'body',\n" + 
        "	position: null,\n" + 
        "	type: \"" + type +
                      "\",\n" + 
        "	allow_dismiss: true,\n" + 
        "	placement: {\n" + 
        "		from: \"top\",\n" + 
        "		align: \"right\"\n" + 
        "	},\n" + 
        "	spacing: 5,\n" + 
        "	z_index: 1031,\n" + 
        "	delay: " + timeout + ",\n" + 
        "	url_target: '_blank',\n" + 
        "	animate: {\n" + 
        "		enter: 'animated fadeInRight',\n" + 
        "		exit: 'animated fadeOutRight'\n" + 
        "	},\n" + 
        "	icon_type: 'class',\n" + 
        "	template: '<div style=\"min-width:400px!important\" data-notify=\"container\" class=\"col-xs-11 col-sm-3 alert alert-{0}\" role=\"alert\">' +\n" + 
        "		'<button type=\"button\" aria-hidden=\"true\" class=\"close\" data-notify=\"dismiss\">×</button>' +\n" + 
        "		'<span data-notify=\"icon\"></span> ' +\n" + 
        "		'<span data-notify=\"title\" class=\"h5\">{1}: </span> ' +\n" + 
        "		'<span data-notify=\"message\">{2}</span>' +\n" + 
        "	'</div>' \n" + 
        "    });");   
        
        ExtendedRenderKitService erks =
            Service.getService(FacesContext.getCurrentInstance().getRenderKit(),
                               ExtendedRenderKitService.class);
        erks.addScript(FacesContext.getCurrentInstance(), script.toString());  
    }
}
