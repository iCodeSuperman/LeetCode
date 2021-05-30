package se.container;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author icodeboy
 */
public class ComparableTest {
    @Test
    public void t1(){
        Person[] ps = new Person[6];
        ps[0] = new Person("aaa", 12);
        ps[1] = new Person("bbb", 40);
        ps[2] = new Person("bbb", 20);
        ps[3] = new Person("ccc", 10);
        ps[4] = new Person("aaa", 10);
        ps[5] = new Person("bbb", 50);
        Arrays.sort(ps);
        for (int i = 0; i < ps.length; i++) {
            System.out.println(ps[i]);
        }
    }

    public void t2(){
        Set st = new HashSet<>();
    }
}

class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(){
        this("默认值", 10);
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(Objects.equals(this.name, o.name)){
            return this.age.compareTo(o.age);
        } else {
            return this.name.compareTo(o.name);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}