package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class leetcode191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result=0;
        while(n!=0){
            n=n&(n-1);
            result++;
        }

//        int result=0;
//        int mask=1;
//        while(n!=0){
//            if((n & mask)==1){
//                result++;
//            }
//            //注意使用无符号右移
//            n=n>>>1;
//        }

        return result;
    }
}
