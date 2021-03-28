package com.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class E401_BinaryWatch {
    /**
     * 方法二：回溯求解
     */
    private int[] hoursArr = {1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private int[] minutesArr = {0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if(num >= 9) return res;
        dfs(num, 0, 0, 0, res);
        return res;
    }

    /**
     *
     * @param cnt 剩余可以点亮的灯数
     * @param start 从索引start开始往后点亮
     * @param hour 已经选择的小时数
     * @param minute 已经选择的分钟数
     * @param res 全部点亮后符合条件的时间
     */
    public void dfs(int cnt, int start, int hour, int minute, List<String> res){
        // 不合理时间，剪枝
        if(hour > 11 || minute > 59){
            return;
        }

        if(cnt == 0){
            //回溯终点
            StringBuffer sb = new StringBuffer();
            sb.append(hour).append(":");
            if(minute < 10){
                sb.append("0");
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for(int i = start; i < 10; i++){
            /**
            * 减少一个需要点亮的灯数量num - 1
            * 从当前已点亮的灯后面选取下一个要点亮的灯 i + 1（防止重复选择）
            * 在hour中增加当前点亮灯的小时数，如果i大于3，当前灯是分钟灯而不是小时灯，则加上0个小时
            * 在minute中增加当前点亮灯的分钟数，如果i没有大于3，当前灯是小时灯而不是分钟灯，则加上0分钟
            */
            dfs(cnt - 1, i + 1, hour+hoursArr[i], minute+minutesArr[i], res);
        }
    }

    /**
     * 方法一：纯暴力求解
     * @param num
     * @return
     */
    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        if(num >= 9) return res;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 60; j++){
                if(num == countOne(i) + countOne(j)){
                    StringBuffer sb = new StringBuffer();
                    sb.append(i).append(":");
                    if(j < 10){
                        sb.append("0");
                    }
                    sb.append(j);
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }

    public int countOne(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }


    @Test
    public void t(){
        System.out.println(this.countOne(0));
        System.out.println((3 == 3 + 2));
    }
}
