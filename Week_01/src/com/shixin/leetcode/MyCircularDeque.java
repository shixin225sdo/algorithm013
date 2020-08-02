package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/2/002.
 */
public class MyCircularDeque {
    Integer[] array=null;
    int size;
    int front;
    int rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array=new Integer[k];
        size=0;
        front=0;
        rear=k-1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size==array.length){
            return false;
        }
        for(int i=front;i>0;i--){
            array[i]=array[i-1];
        }
        array[0]=value;
        size++;
        front++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size==array.length){
            return false;
        }
        for(int i=array.length-1;i>rear;i--){
            array[i-1]=array[i];
        }
        array[array.length-1]=value;
        size++;
        rear--;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        for(int i=0;i<front;i++){
            array[i]=array[i+1];
        }

        size--;
        front--;
        array[front]=null;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        for(int i=array.length-2;i>rear;i--){
            array[i+1]=array[i];
        }
        size--;
        rear++;
        array[rear]=null;

        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0){
            return -1;
        }
        return array[0];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0){
            return -1;
        }
        return array[array.length-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==array.length;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4


    }
}
