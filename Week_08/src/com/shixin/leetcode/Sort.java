package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class Sort {
    public boolean myCompartor(int a,int b){
        return a<b;
    }
    public void buppleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(!myCompartor(arr[j],arr[j+1])){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(!myCompartor(arr[minIndex],arr[j])){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
    public void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && !myCompartor(arr[preIndex], current)) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public void mergeSort(int arr[],int left,int right){

        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,right,mid);
        }

    }
    public void merge(int arr[],int left,int right,int mid){
        int[] temp=new int[right-left+1];
        int firstStart=left;
        int secondStart=mid+1;
        int k=0;
        while(firstStart<=mid && secondStart<=right){
            if(myCompartor(arr[firstStart],arr[secondStart])){
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

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,1,3,2,4,6,7,9,2,19};
        new Sort().mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
