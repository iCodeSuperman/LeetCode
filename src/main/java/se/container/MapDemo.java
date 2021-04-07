package se.container;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author icodeboy
 * map 遍历的四种方式
 */
public class MapDemo {

    /**
     * 方法一：在for循环中使用entries实现Map的遍历
     *      最常见也是大多数情况下用的最多的，一般在键值对都需要使用时
     */
    @Test
    public void demo1(){
        Map<String, String> map = new HashMap<>(2);
        map.put("徐彦祖", "好帅");
        map.put("彭于晏","没有彦祖帅");
        // map.entrySet().for 快捷键
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * 方法二：在for循环中遍历key或者values
     *       一般适用于只需要map中的key或者value时使用，性能上比使用entrySet较好
     */
    @Test
    public void demo2(){
        Map<String, String> map = new HashMap<>(2);
        map.put("徐彦祖", "好帅");
        map.put("彭于晏","没有彦祖帅");
        // map.keySet().for
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // map.values().for
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    /**
     * 方法三：通过Iterator遍历
     */
    @Test
    public void demo3(){
        Map<String, String> map = new HashMap<>(2);
        map.put("徐彦祖", "好帅");
        map.put("彭于晏","没有彦祖帅");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * 方法四：通过键找值遍历，效率比较低，从键取值是耗时的操作
     */
    @Test
    public void demo4(){
        Map<String, String> map = new HashMap<>(2);
        map.put("徐彦祖", "好帅");
        map.put("彭于晏","没有彦祖帅");
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + ":" + value);
        }

    }

}
