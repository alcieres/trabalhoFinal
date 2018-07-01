/* Copyright 2015 Oracle and/or its affiliates. All rights reserved. */
package com.example.employees;

import java.util.Optional;
import org.apache.catalina.startup.Tomcat;
//Import the Optional class

public class Main {
    
    public static final Optional<String> PORT = Optional.ofNullable(System.getenv("PORT"));
    //Create a PORT instance variable
    
    public static void main(String[] args) throws Exception {
        String contextPath = "/" ;
        String appBase = ".";
        Tomcat tomcat = new Tomcat();  
        tomcat.setPort(Integer.valueOf(PORT.orElse("8081")));     
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
}