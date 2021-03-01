package com.medium;

import java.util.*;

public class M721_AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFindFor721 uf = new UnionFindFor721(n);

        /**
         * 建立email-id的联系
         */
        Map<String, Integer> emailToId = new HashMap<>();
        //注意这里从1开始
        for(int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            for(int j = 0; j < account.size(); j++){
                String email = account.get(j);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, i);
                }else {
                    uf.union(i, emailToId.get(email));
                }
            }
        }

        /**
         * 建立id-email列表的联系
         */
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for(Map.Entry<String, Integer> entry : emailToId.entrySet()){
            // 这里，将同一个连通域，不同邮箱可能对应不同的id，统一为根id
            int id = uf.find(entry.getValue());
            // id - 邮箱列表。不存在id则重新建立；存在则拉取整个列表
            List<String> emails = idToEmails.getOrDefault(id, new ArrayList<>());
            emails.add(entry.getKey());
            idToEmails.put(id, emails);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry : idToEmails.entrySet()){
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> tmp = new ArrayList<>();
            // accounts.get(id).get(0); 先添加用户名
            tmp.add(accounts.get(entry.getKey()).get(0));
            tmp.addAll(emails);
            res.add(tmp);
        }
        return res;
    }
}

class UnionFindFor721{
    private int count;
    private int[] fa;
    private int[] size;

    public UnionFindFor721(int n){
        fa = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        if(size[rootP] > size[rootQ]){
            fa[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }else{
            fa[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int find(int x){
        int root = x;
        while(root != fa[root]){
            root = fa[root];
        }

        while(x != fa[x]){
            int temp = fa[x];
            fa[x] = root;
            x = temp;
        }
        return root;
    }
}












