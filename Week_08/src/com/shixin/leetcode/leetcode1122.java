package com.shixin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class leetcode1122 {
    public boolean myCompartor(int a,int b,Map<Integer,Integer> map,int length){
       return map.getOrDefault(a,a+length)<map.getOrDefault(b,b+length);
    }
    public void mergeSort(int arr[],int left,int right,Map<Integer,Integer> map,int length){

        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,map,length);
            mergeSort(arr,mid+1,right,map,length);
            merge(arr,left,right,mid,map,length);
        }

    }
    public void merge(int arr[],int left,int right,int mid,Map<Integer,Integer> map,int length){
        int[] temp=new int[right-left+1];
        int firstStart=left;
        int secondStart=mid+1;
        int k=0;
        while(firstStart<=mid && secondStart<=right){
            if(myCompartor(arr[firstStart],arr[secondStart],map,length)){
                temp[k++]=arr[firstStart++];
            }else{
                temp[k++]=arr[secondStart++];
            }
        }
        while(firstStart<=mid){
            temp[k++]=arr[firstStart++];
        }
        while(secondStart<=right){
            temp[k++]=arr[secondStart++];
        }
        for(int offset=0;offset<temp.length;offset++){
            arr[left+offset]=temp[offset];
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],i);
        }
        mergeSort(arr1,0,arr1.length-1,map,arr2.length);
        return arr1;
    }
}
