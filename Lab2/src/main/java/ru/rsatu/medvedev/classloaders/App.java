/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rsatu.medvedev.classloaders;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author emedvedev
 */
public class App {
    
     private static final Map<String,Object> MAP = new HashMap<String,Object>() 
       {{       
            put("1", 1);     
            put("2", 2);     
            put("3", 3);     
            put("4", 4);     
            put("5", 5);     
            put("6", 6);  
       }}; 

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws Exception {
        
        MyClassLoader loader1 = new MyClassLoader();
        MyClassLoader loader2 = new MyClassLoader();
        
        Class cl1 = loader1.findClass("ru.rsatu.medvedev.classloaders.MyClass");
        Class cl2 = loader2.findClass("ru.rsatu.medvedev.classloaders.MyClass2");
        
        
        Constructor constructor = cl1.getDeclaredConstructor(Object.class);
        constructor.setAccessible(true);
        
        Object c2 = cl2.newInstance();
        Object c1 = constructor.newInstance(c2);

        MyInterface ci1 =  (MyInterface) c1;
        MyInterface ci2 =  (MyInterface) c2;
        
        ci1.set("It's work!");
        System.out.println(ci1.get());
        System.out.println(ci2.get());
        
        //Method method1 = cl1.getMethod("set", new Class[] {String.class});
        //method1.invoke(c1, new Object[]{"reflection"});
        //Method method2 = cl1.getMethod("get");
        //System.out.println(method2.invoke(c1));
        
        Info info = new Info();
        String out = info.getAllInfo(cl1);
        System.out.println("Class 1 info:");
        System.out.println(out);
        out = info.getAllInfo(cl2);
        System.out.println("Class 2 info:");
        System.out.println(out);
    }
    
}
