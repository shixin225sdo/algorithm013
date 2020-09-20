package com.shixin.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/9/20/020.
 */
public class leetcode242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);

    }
}
