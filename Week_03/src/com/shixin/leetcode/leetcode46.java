package com.shixin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/16/016.
 */
public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        permuteResu(result,new ArrayList<Integer>(),nums);
        return result;
    }
    public void permuteResu( List<List<Integer>> result,List<Integer> permuteResult,int[] nums){
        //1.终止条件
        if(permuteResult.size()==nums.length){
            result.add(new ArrayList<Integer>(permuteResult));
            return;
        }
        //2.各个选择
        for(int i=0;i< nums.length;i++){
            if(permuteResult.contains(nums[i])){
                continue;
            }
            permuteResult.add(nums[i]);
            //3.递归该选择的后续
            permuteResu(result,permuteResult,nums);
            //4.回退该选择
            permuteResult.remove(permuteResult.size()-1);
        }
    }
}
