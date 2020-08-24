package com.shixin.leetcode;

import java.util.*;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode127 {
    public int ladderLength(String beginWord,String endWord,List<String> wordList){
        //广度优先遍历需要队列
        Queue<String> queue=new LinkedList<String>();
        //需要访问过的标识，使得bfs不会出现回头路
        boolean[] isVisited=new boolean[wordList.size()];
        if(wordList==null || wordList.size()==0 || !wordList.contains(endWord)){
            return 0;
        }
        queue.add(beginWord);
        wordList.remove(beginWord);
        int depth=0;
        while(!queue.isEmpty()){
            depth++;
            int size=queue.size();
            for(int j=0;j<size;j++){
                String currword=queue.poll();
                for(int i=0;i<wordList.size();i++){
                    if(isVisited[i]){
                        continue;
                    }
                    if(canConvert(currword,wordList.get(i))){
                        if(endWord.equals(wordList.get(i))){
                            return ++depth;
                        }
                        queue.add(wordList.get(i));
                        isVisited[i]=true;
                    }
                }
            }
        }
       return 0;
    }


    public boolean canConvert(String src,String target){
        if(src.length()!=target.length()){
            return false;
        }
        int enqualCount=0;
        for(int i=0;i<src.length();i++){
            if(src.charAt(i)==target.charAt(i)){
                enqualCount++;
            }
        }
        if(enqualCount==src.length()-1 || enqualCount==src.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        List<String> test=new ArrayList<String>();
        test.addAll(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(new leetcode127().ladderLength("hit","cog",test));
    }
}
