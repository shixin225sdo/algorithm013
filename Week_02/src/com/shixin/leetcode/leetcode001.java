package com.shixin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/8/8/008.
 */
public class leetcode001 {

    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        //2.时间复杂度：O(n)
        Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int aim=target-nums[i];
            if(temp.containsKey(aim)){
                result[0]=i;
                result[1]=temp.get(aim);
                return result;
            }else{
                temp.put(nums[i],i);
            }
        }
        return result;


        //1.时间复杂度：O(n^2)
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    result[0]=i;
//                    result[1]=j;
//                    return result;
//                }
//            }
//        }
//        return result;
    }
}
