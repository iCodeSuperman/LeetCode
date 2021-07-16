package se.basicknowledge;

import org.junit.Test;
import se.domain.TargetObject;

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

    @Test
    public void t(){
        int a = Integer.MAX_VALUE;
        long b = 2 * (long)a;
        long b1 = (long)Math.pow(2, 24) * 255 + 255 * 256 * 256 + 255 * 256+ 255;
        System.out.println(b);
        System.out.println(b1);
    }

}


