package com.shixin.leetcode;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class leetcode231 {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n &(n-1))==0?true:false;
    }
}
