package se.basicknowledge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Arrays.asList使用注意事项
 * 1. 传递的数组必须是对象数组，而不是基本类型。
 * 2. 使用集合的修改方法:add()、remove()、clear()会抛出异常。
 * 3.
 */
public class UseArraysAsList {
    @Test
    public void t(){
        String[] strArr = {"hello", "world"};
        List<String> list = Arrays.asList(strArr);
        System.out.println(list.getClass());
        //list.add("hello"); //异常
        strArr[0] = "hi";
        //list.get(0)也随之修改
        System.out.println(list.get(0));
    }

    /**
     * 如何将数组转ArrayList
     */
    <T> List<T> ArrayToList(final T[] arr){
        final List<T> list = new ArrayList<T>(arr.length);
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }

    @Test
    public void t1(){
        Integer[] arr = {1, 2, 3};
        List<Integer> list = ArrayToList(arr);
        System.out.println(list.getClass());
        list.add(4);
        System.out.println(list);
    }

    @Test
    public void t2(){
        Integer[] arr = {1, 2, 3};
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        System.out.println(list.getClass());
    }

    @Test
    public void t3(){
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(list.getClass());

        int[] arr2 = {1, 2, 3};
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(list.getClass());
    }
}
