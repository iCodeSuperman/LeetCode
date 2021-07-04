package second;

import se.arithmetic.PriorityQueueMax;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class Q347 {

    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        // 统计出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        };

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (a, b) -> {
            return b.getValue().compareTo(a.getValue());
        });

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            priorityQueue.add(e);
        }


        for(int i = 0; i < k; i++){
            res[i] = priorityQueue.poll().getKey();
        }

        return res;
    }


    // 统计key-value键值对，然后对value快速排序，取出前k个
    public int[] topKFrequent3(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        };

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            return b.getValue().compareTo(a.getValue());
        });

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if(i == k){
                break;
            }
            int key = entry.getKey();
            int value = entry.getValue();
            res[i] = key;
            //System.out.println("key = " + key + "; value = " + value);
            i++;
        }

        return res;
    }
}
