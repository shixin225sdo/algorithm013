package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class leetcode190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        int mask=1;
        for(int i=0;i<32;i++){
            result=result<<1;
            result=result | (n & mask);
            n=n>>>1;
        }
        return result;
    }
}
