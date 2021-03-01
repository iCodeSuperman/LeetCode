package com.medium;

import java.util.*;

public class M355_DesignTwitter {

}

class Twitter {
    /**
     * 全局时间戳
     */
    private static int timestamp = 0;
    /**
     * 用户类
     */
    private static class User{
        private int uid;
        public Set<Integer> followed; // 关注列表
        public Tweet head; // 用户发推文的表头结点

        public User(int userId){
            followed = new HashSet<>();
            this.uid = userId;
            this.head = null;
            // 关注一下自己
            follow(uid);
        }

        public void follow(int userId){
            followed.add(userId);
        }

        public void unFollow(int userId){
            if(userId != this.uid){
                followed.remove(userId);
            }
        }

        public void post(int tweetId){
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;
            // 将新建的推文插入链表表头
            // 越靠前，time的值越大
            twt.next = head;
            head = twt;
        }
    }

    /**
     * 推文类
     */
    private static class Tweet{
        private int time;
        private int tid;
        private Tweet next;
        public Tweet(int tid, int time){
            this.tid = tid;
            this.time = time;
            this.next = null;
        }
    }


    private Map<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if(twt == null) continue;
            pq.add(twt);
        }


        while(!pq.isEmpty()){
            if(res.size() == 10) break;
            Tweet twt = pq.poll();
            res.add(twt.tid);
            // 将twt下一个结点放入优先队列，保证了每次都取不同队列中的最大值
            if(twt.next != null){
                pq.add(twt.next);
            }
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)){
            userMap.get(followerId).unFollow(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
