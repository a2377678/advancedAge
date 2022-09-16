package com.example.springboot.controller; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleGlobalException(HttpServletRequest req, Exception e) {
        //列印異常資訊：
        //e.printStackTrace();
        System.out.println("GlobalExceptionHandler.handleGlobalException()");
        
        return e.getMessage();
    }

}