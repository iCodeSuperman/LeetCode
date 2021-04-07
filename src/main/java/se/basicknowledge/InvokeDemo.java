package se.basicknowledge;

import se.domain.TargetObject;

import java.lang.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author icodeboy
 */
public class InvokeDemo {
    public static void main(String[] args) throws Exception{
        Class<?> targetClass = Class.forName("se.domain.TargetObject");
        TargetObject targetObject = (TargetObject)targetClass.newInstance();

        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "xuyanzu");

        Field value = targetClass.getDeclaredField("value");
        value.setAccessible(true);
        value.set(targetObject, "hello");

        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);

    }
}


