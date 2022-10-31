package com.honghung.session;

import javax.servlet.http.HttpSession;

public  class Session {
    public static HttpSession session ;
    public static void setSession(String name, String value){
        if(session.getAttribute(name) == null){
            session.setAttribute(name,value);
        }
    }
    public static void setSession(String name, int value){
        if(session.getAttribute(name) == null){
            session.setAttribute(name,value);
        }
    }
    public static void setSession(String name, boolean value){
        if(session.getAttribute(name) == null){
            session.setAttribute(name,value);
        }
    }
    public static String getSession(String name){
            return (String) session.getAttribute(name );
    }
}
