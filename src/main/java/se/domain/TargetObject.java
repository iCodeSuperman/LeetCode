package se.domain;

import java.io.Serializable;

/**
 * @author icodeboy
 */
public class TargetObject implements Serializable {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
