package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/2/002.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{1,1,2});
    }
}
