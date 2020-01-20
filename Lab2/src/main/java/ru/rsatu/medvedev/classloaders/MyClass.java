/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.classloaders;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class MyClass implements MyInterface {
    
    Object c;
    
    MyClass(Object c) {
        this.c = c;
    }

    @Override
    public String get() {
        String result = null;
        try {
            Method method1 = c.getClass().getMethod("get");
            result = (String) method1.invoke(c);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.toUpperCase();
    }

    @Override
    public void set(String val) {
        ((MyInterface)c).set(val);
    }
    
}
