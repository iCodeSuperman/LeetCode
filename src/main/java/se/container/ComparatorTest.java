package se.container;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author icodeboy
 */
public class ComparatorTest {

    /**
     * Comparator 定制排序
     */
    @Test
    public void t1(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原始数组：");
        System.out.println(arrayList);

        System.out.println("自然排序：");
        Collections.sort(arrayList);
        System.out.println(arrayList);

        System.out.println("自定义排序：");
        Collections.sort(arrayList, (o1, o2) -> {
            return o2.compareTo(o1);
        });
        System.out.println(arrayList);

    }
}
