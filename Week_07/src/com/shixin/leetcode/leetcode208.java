package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/9/13/013.
 */
public class leetcode208 {
    private class TrieNode{
        private TrieNode[] links;
        private boolean isEnd;
        public TrieNode(){
            links=new TrieNode[26];
            isEnd=false;
        }
        public boolean containsKey(char serarchKey){
            return get(serarchKey)!=null?true:false;
        }
        public void put(char putKey){
            links[putKey-'a']=new TrieNode();
        }
        public TrieNode get(char getKey){
            return links[getKey-'a'];
        }
        public void setEnd(){
            isEnd=true;
        }
     }
    private TrieNode root;
    /** Initialize your data structure here. */
    public leetcode208() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode=root;
        for(char currentChar:word.toCharArray()){
            if(!curNode.containsKey(currentChar)){
                curNode.put(currentChar);
            }
            curNode=curNode.get(currentChar);
        }
        curNode.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode=root;
        for(char currentChar:word.toCharArray()){
            if(curNode.containsKey(currentChar)){
                curNode=curNode.get(currentChar);
            }else{
                return false;
            }
        }
        return curNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode=root;
        for(char currentChar:prefix.toCharArray()){
            if(curNode.containsKey(currentChar)){
                curNode=curNode.get(currentChar);
            }else{
                return false;
            }
        }
        return true;
    }
}
