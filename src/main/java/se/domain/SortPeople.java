package se.domain;

import java.io.Serializable;

/**
 * @author icodeboy
 */
public class SortPeople implements Comparable<SortPeople>{
    private String name;
    private Integer age;
    private Integer score;

    public SortPeople(){
        this("Angela", 18, 100);
    }

    public SortPeople(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SortPeople{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(SortPeople o) {
        return 0;
    }
}
