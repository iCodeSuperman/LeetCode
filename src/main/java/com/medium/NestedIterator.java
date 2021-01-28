package com.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class NestedInteger{
   private Integer val;
   private List<NestedInteger> list;

   public NestedInteger(Integer val){
       this.val = val;
       this.list = null;
   }

   public NestedInteger(List<NestedInteger> list){
       this.val = null;
       this.list = list;
   }

   public boolean isInteger(){
       return val != null;
   }

   public Integer getInteger(){
       return this.val;
   }

   public List<NestedInteger> getList(){
       return this.list;
   }
}

public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    public Integer next() {
        return list.remove(0).getInteger();
    }

    public boolean hasNext() {
        // 循环拆分列表元素，直到列表第一个元素是整数类型
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            // 当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> first = list.remove(0).getList();
            // 将第一个列表打平并按顺序添加到开头
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();

    }
}
