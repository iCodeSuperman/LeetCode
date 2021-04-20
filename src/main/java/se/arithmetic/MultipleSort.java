package se.arithmetic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.domain.SortPeople;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author icodeboy
 */
public class MultipleSort {

    SortPeople[] arr = new SortPeople[5];
    List<SortPeople> list = new ArrayList<>();

    @Before
    public void init(){
        arr[0] = new SortPeople("Dav", 20, 100);
        arr[1] = new SortPeople("Bob", 20, 90);
        arr[2] = new SortPeople("Bob", 21, 70);
        arr[3] = new SortPeople("Dav", 20, 90);
        arr[4] = new SortPeople("Dav", 20, 80);

        for(int i = 0; i < 5; i++){
            list.add(arr[i]);
        }
    }

    @Test
    public void testSortArr(){
        Arrays.sort(arr, (p1, p2) -> {
            if(p1.getName().compareTo(p2.getName()) == 0){
                if(p1.getAge().compareTo(p2.getAge()) == 0){
                    return p1.getScore().compareTo(p2.getScore());
                }else{
                    return p1.getAge().compareTo(p2.getAge());
                }
            }else{
                return p1.getName().compareTo(p2.getName());
            }
        });
    }


    /**
     * 容器 java8 流排序
     */
    @Test
    public void testSortList(){
        //This is similar SYNTAX to the Streams above, but it sorts the original list!!
        list.sort(Comparator.comparing(SortPeople::getName)
                .thenComparing(SortPeople::getAge).thenComparing(SortPeople::getScore, Comparator.reverseOrder()));
    }


    /**
     * 容器 java8 lambda
     */
    @Test
    public void testSortListByLambda(){
        list.sort((p1, p2) -> {
            if(p1.getName().compareTo(p2.getName()) == 0){
                if(p1.getAge().compareTo(p2.getAge()) == 0){
                    return p1.getScore().compareTo(p2.getScore());
                }else{
                    return p1.getAge().compareTo(p2.getAge());
                }
            }else{
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    @After
    public void print(){
        for (SortPeople people : arr) {
            System.out.println(people);
        }
    }
}

