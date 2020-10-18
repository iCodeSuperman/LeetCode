package com.medium;

import org.junit.Test;

import java.util.*;

public class M127_WordLadder {
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || wordSet.contains(endWord) == false){
            return 0;
        }
        wordSet.remove(beginWord);

        int wordLen = beginWord.length();
        int step = 1;

        Queue<String> queue = new LinkedList<>(); //广度搜索队列
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>(); //用于标记已经访问过的单词
        visited.add(beginWord);

        while(queue.isEmpty() == false){
            int levelLen = queue.size();
            for(int i = 0; i < levelLen; i++){ //将广度搜索每一层入队的结点都一次性访问
                String currentWord = queue.remove();

                //根据单词长度，进行每一位字母从'a'到'z'的替换
                char[] charArray = currentWord.toCharArray();
                for(int j = 0; j < wordLen; j++){
                    char originalChar = charArray[j]; //牢记后面要将数组还原
                    for(char k = 'a'; k <= 'z'; k++){
                        if(k == originalChar){
                            continue;
                        }
                        charArray[j] = k;
                        String tempWord = String.valueOf(charArray);
                        if(wordSet.contains(tempWord)){
                            if(endWord.equals(tempWord)){
                                return step + 1;
                            }
                            if(visited.contains(tempWord) == false){
                                queue.offer(tempWord);
                                visited.add(tempWord);
                            }

                        }
                    }
                    charArray[j] = originalChar;
                }
            }
            step++;
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || wordSet.contains(endWord) == false){
            return 0;
        }
        wordSet.remove(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int wordLen = beginWord.length();
        int step = 1;
        while(beginVisited.size() > 0 && endVisited.size() > 0){

            if(beginVisited.size() > endVisited.size()){ //保证beginVisited为元素数量较小的集合
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }
            Set<String> nextLevelVisited = new HashSet<>();

            for (String word : beginVisited) {
                char[] charArray = word.toCharArray();
                for(int j = 0; j < wordLen; j++){
                    char originalChar = charArray[j];
                    for(char k = 'a'; k <= 'z'; k++){
                        if(k == originalChar){
                            continue;
                        }
                        charArray[j] = k;
                        String tempWord = String.valueOf(charArray);
                        if(wordSet.contains(tempWord)){
                            if(endVisited.contains(tempWord)){
                                return step + 1;
                            }
                            if(visited.contains(tempWord) == false){
                                nextLevelVisited.add(tempWord);
                                visited.add(tempWord);
                            }
                        }

                    }
                    charArray[j] = originalChar;
                }
            }
            beginVisited = nextLevelVisited;
            step++;
        }

        return 0;
    }
    @Test
    public void t(){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        //String[] wordListArray = new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"};
        Collections.addAll(wordList, wordListArray);
        M127_WordLadder solution = new M127_WordLadder();
        int res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    @Test
    public void t2(){
        char[] arr = {'a', 'b', 'c'};
        String s = String.valueOf(arr);
        System.out.println(s);
    }
}
