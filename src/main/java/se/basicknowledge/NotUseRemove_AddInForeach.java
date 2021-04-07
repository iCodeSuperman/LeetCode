package se.basicknowledge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class NotUseRemove_AddInForeach {
    /**
     * [注意]不要在 foreach 循环里进行元素的 remove/add 操作
     * 如果要进行remove操作，可以调用迭代器的 remove 方法而不是集合类的 remove 方法。
     * 因为如果列表在任何时间从结构上修改创建迭代器之后，以任何方式除非通过迭代器自身remove/add方法，
     * 迭代器都将抛出一个ConcurrentModificationException,这就是单线程状态下产生的 fail-fast 机制。
     */

    /**
     * 正例子
     */
    @Test
    public void test01(){
        List<String>  list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            if(Objects.equals(item, "2")){
                iterator.remove();;
            }
            System.out.println(item);
        }
        System.out.println(list);
    }

    /**
     * 反例子
     */
    @Test
    public void test02(){
        List<String>  list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if(Objects.equals(item, "2")){
                list.remove(item);
            }
        }
        System.out.println(list);
    }
}
