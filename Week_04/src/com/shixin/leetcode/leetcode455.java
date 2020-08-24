package com.shixin.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/8/23/023.
 */
public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        int result=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0,j=0;i<s.length && j<g.length;i++){
            if(g[j]<=s[i]){
                result++;
                j++;
            }else{
                continue;
            }
        }
        return result;
    }
}
