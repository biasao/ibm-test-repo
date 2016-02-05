package com.ibm.watson.health.utilities.service;
public final class ResourceConstants {

    public static final int CODE_401 = 401;
    public static final String CODE_401_TEXT = "User in authorization header parameter not valid.";

    public static final int  CODE_403 = 403;
    public static final String CODE_403_TEXT = "The user is forbidden to perform this action.";
   
    public static final int  CODE_404 = 404;
   
    public static final String CONTEXT_DESCRIPTION = "HTTP Request context";
   
    private ResourceConstants() {
       
    }

}