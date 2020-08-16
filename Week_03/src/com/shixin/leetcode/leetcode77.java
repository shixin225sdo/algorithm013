package com.shixin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/16/016.
 */
public class leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        combineResu(result,new ArrayList<Integer>(),1,n,k);
        return result;
    }
    private void combineResu( List<List<Integer>> result,List<Integer> combineResult,int start,int n,int k){
        //1.终止条件
        if(combineResult.size()==k){
            result.add(new ArrayList<Integer>(combineResult));
            return;
        }
        //2.各个选择
        for(int i=start;i<=n;i++){
            combineResult.add(i);
            //3.递归该选择的后续
            combineResu(result,combineResult,i+1,n,k);
            //4.回退该选择
            combineResult.remove(combineResult.size()-1);
        }
    }
}
