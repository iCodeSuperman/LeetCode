package se.operateSystem;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author icodeboy
 * @title 银行家算法实现
 * @算法流程：
 *  1. 初始时刻状态：
 *      - 最大需求矩阵max：记录了每个进程对各类资源的最大需求
 *      - 分配矩阵allocation：记录了每个进程对各类资源的当前占有量
 *      - 需求矩阵need：记录每个进程对各类资源的进一步需求，是max-allocation
 *      - 可用资源向量available：记录了系统中各类资源的当前可用数目
 *      - 请求向量request：记录某个进程对当前各类资源的申请量，是银行家算法的入口参数
 *  2. 安全性检测：
 *      - 当前时刻不安全：退出
 *      - 系统安全，允许进程P[i]提出request[r]
 *  3. 核查进程的request是否有效
 *      - request[r] <= need[p][r]
 *      - request[r] <= available[r]
 *      上述两个条件都满足，才能进入试探性分配
 *  4. 试探性分配
 *      - available[r] = available[r] - request[r]
 *      - allocation[p_i][r] = allocation[p_i] + request[r]
 *      - need[p_i][r] = need[p_i][r] - request[r]
 *  5. 通过安全性检查，则分配
 */
public class BankerAlgorithm {
    // p 进程数，r资源种类
    private int p;
    private int r;
    private int[][] maxs;
    private int[][] allocation;
    private int[][] need;
    private int[] available;
    private int[] request;

    /**
     * 初始化函数，赋值
     */
    public void init(){
        p = 4; r = 3;
        maxs = new int[][]{{3, 2, 2}, {6, 1, 3}, {3, 1, 4}, {4, 2, 2}};
        allocation = new int[][]{{1, 0, 0}, {5, 1, 1}, {2, 1, 1}, {0, 0, 2}};
        need = new int[p][r];
        for(int i = 0; i < p; i++){
            for (int j = 0; j < r; j++) {
                need[i][j] = maxs[i][j] - allocation[i][j];
            }
        }
        available = new int[]{1, 1, 2};

    }

    /**
     * 比较函数，进程m中元素全大于n中元素，则返回true
     * @param m
     * @param n
     * @return
     */
    public boolean compare(int[] m, int[] n){
        for (int i = 0; i < r; i++) {
            if(m[i] < n[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 安全性检查函数
     * @return
     * 安全性检查算法流程：
     *  1. 初始化：work = available; finish[i] = false;
     *  2. 按照进程编号顺序找到了一个可以加入安全序列的进程，即满足finish[i]=false
     *     且need[i]<=work的进程i。则假设进程i不就后完成任务并归还资源，于是设置
     *     work = work+allocation[i] 和 finish[i] = true; 然后重复执行这一步。
     *  3. 若finish均为true，返回true。否则返回false。
     */
    public boolean safeTest(){
        boolean flag = false;
        // finish[i]表示进程pi是否可以加入安全序列
        boolean[] finish = new boolean[p];
        // 记录系统中各类资源当前可用数目
        int[] work = new int[r];

        // 初始化
        Arrays.fill(finish, false);
        for (int i = 0; i < r; i++) {
            work[i] = available[i];
        }

        // 双重循环，找到一个安全序列，其中finish类似一个标记访问过的矩阵。
        for (int k = 0; k < p; k++) {
            for (int i = 0; i < p; i++) {
                if(finish[i] == true){
                    continue;
                }else{
                    if(compare(work, need[i])){
                        // available >= need[i]
                        finish[i] = true;
                        flag = true;
                        for (int j = 0; j < r; j++) {
                            work[j] = work[j] + allocation[i][j];
                        }
                        break;
                    }
                }

                if(flag == true){
                    break;
                }
            }
        }

        for (int i = 0; i < p; i++) {
            if(finish[i] == false){
                // 存在不安全序列
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param n 进程号
     */
    public void requestTest(int n){
        //available>=request 并且 need >=request
        if(compare(available, request) && compare(need[n - 1], request)){
            for (int i = 0; i < r; i++) {
                allocation[n - 1][i] = allocation[n - 1][i] + request[i];
                need[n - 1][i] = need[n - 1][i] - request[i];
                available[i] = available[i] - request[i];
            }
        }

        if(safeTest()){
            System.out.println("允许进程"+n+"申请资源！");
        }else {
            System.out.println("不允许进程"+n+"申请资源！");
        }
    }

    @Test
    public void test(){
        // 进程n和请求资源request矩阵
        int n = 1;
        request = new int[]{0, 1, 0};
        // 初始化资源
        init();
        if(safeTest()){
            System.out.println("存在安全序列，初始状态安全！");
        }else{
            System.out.println("不存在安全序列，初始状态安全！");
        }
        // 进程n发出资源请求
        requestTest(n);
    }

}
