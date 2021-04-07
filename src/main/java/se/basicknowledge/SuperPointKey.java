package se.basicknowledge;

public class SuperPointKey {
}

class People{
    private String name;
    private Integer age;
    public People(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}

class Student extends People{

    public Student(String name, Integer age) {
        super(name, age);
    }
}