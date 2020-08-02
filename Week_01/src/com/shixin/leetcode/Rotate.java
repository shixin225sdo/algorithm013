package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/2/002.
 */
public class Rotate {
    //2.翻转法
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int startIndex,int endIndex){
        while(startIndex<endIndex){

            int temp=nums[startIndex];
            nums[startIndex]=nums[endIndex];
            nums[endIndex]=temp;
            startIndex++;
            endIndex--;
        }
    }


         //1.暴力解决
//        for(int i=0;i<k;i++){
//            int temp=0;
//            int prevTemp=nums[0];
//            for(int j=0;j<nums.length;j++){
//                int nextIndex=(j+1)%nums.length;
//                temp=nums[nextIndex];
//                nums[nextIndex]=prevTemp;
//                prevTemp=temp;
//
//            }
//        }
     public static void main(String[] args) {
        new Rotate().rotate(new int[]{-1,-100,3,99},2);

    }
}
