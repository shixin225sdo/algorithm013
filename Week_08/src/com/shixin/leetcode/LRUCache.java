package com.shixin.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class LRUCache {
    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode(){

        }
        public DLinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private DLinkNode head;
    private DLinkNode tail;
    private HashMap<Integer,DLinkNode> hashCache;
    private int size;
    private int capacity;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head=new DLinkNode();
        tail=new DLinkNode();
        head.next=tail;
        tail.prev=head;
        hashCache=new HashMap<>();
    }
    public void removeNode(DLinkNode node){
        if(size==0){
            return;
        }
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.prev=null;
        node.next=null;
        hashCache.remove(node.key);
        size--;
    }
    public void removeTailNode(){
        if(size==0){
            return;
        }
        DLinkNode node=tail.prev;
        removeNode(node);
    }
    public void add2Head(DLinkNode node){
        if(size+1>capacity){
            removeTailNode();
        }
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
        hashCache.put(node.key,node);
        size++;
    }
    public void move2Head(DLinkNode node){
        removeNode(node);
        add2Head(node);
    }
    public int get(int key) {
        DLinkNode node=hashCache.get(key);
        if(node==null){
            return -1;
        }else{
            move2Head(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkNode node=hashCache.get(key);
        if(node==null){
            node=new DLinkNode(key,value);
            add2Head(node);
        }else{
            node.value = value;
            move2Head(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(2, 2);
        cache.get(2);       // 返回  1
        cache.put(1, 1);    // 该操作会使得关键字 2 作废
        cache.put(4,1);       // 返回 -1 (未找到)
        cache.get(2);    // 该操作会使得关键字 1 作废
    }
}
