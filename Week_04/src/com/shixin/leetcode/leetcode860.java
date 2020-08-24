package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            if(bills[i]==10){
                if(five<=0){
                    return false;
                }
                five--;
                ten++;
            }
            if(bills[i]==20){
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>3){
                    five=five-3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
