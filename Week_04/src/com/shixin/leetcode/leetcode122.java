package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode122 {
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                sum=sum+(prices[i+1]-prices[i]);
            }
        }
        return sum;
    }
}
