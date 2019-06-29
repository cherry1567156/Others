package com.succez.classLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeClassLoderTest {
	public static void main(String args[]) {
		DeClassLoader diskLoader = new DeClassLoader("D:\\Cherry");
        try {
            //加载class文件
            Class c = diskLoader.loadClass("com.succez.classLoader.ClassTest");

            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say",null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException 
                        | NoSuchMethodException
                        | SecurityException | 
                        IllegalArgumentException | 
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
