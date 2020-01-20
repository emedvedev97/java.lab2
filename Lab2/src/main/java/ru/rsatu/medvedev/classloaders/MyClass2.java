/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.classloaders;

/**
 *
 * @author emedvedev
 */
public class MyClass2 implements MyInterface {

    private String str = "default";
   
    @Override
    public String get() {
        return str;
    }

    @Override
    public void set(String val) {
        this.str = val;
    }
    
}
