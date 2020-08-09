package com.shixin.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2020/8/8/008.
 */
public class leetcode242 {
    public boolean isAnagram(String s, String t) {
        //2.时间复杂度：O(n)
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> countMap=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            Integer sCharCount=countMap.getOrDefault(s.charAt(i),0)+1;
            countMap.put(s.charAt(i),sCharCount);
            Integer tCharCount=countMap.getOrDefault(t.charAt(i),0)-1;
            countMap.put(t.charAt(i),tCharCount);
        }
        for(Character c:countMap.keySet()){
            if(countMap.get(c)!=0){
                return false;
            }
        }
        return true;

        //1.时间复杂度：O(nlogn)
//        char[] sArray=s.toCharArray();
//        char[] tArray=t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        return new String(sArray).equals(new String(tArray));
    }
}
