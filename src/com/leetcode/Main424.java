package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main424 {
    public int characterReplacement(String s, int k) {
        int []map=new int[26];
        // 窗口内出现次数最多的字符的出现次数
        int maxCount=0;
        char []a=s.toCharArray();
        int left=0,right=0;
        int res=0;
        // right一直向右扩充
        for(right=0;right<a.length;right++){
            map[a[right]-'A']++;
            // 每扩充一格 就重新计算maxCount
            maxCount=Math.max(maxCount,map[a[right]-'A']);

            // 重复字符可以填满整个窗口,更新结果。
            if(right-left+1-maxCount<=k){
                res=Math.max(right-left+1,res);
            }
            // 窗口大小 减去 重复字符出现次数>k ，说明重复字符不能填满整个窗口
            else {
                map[a[left]-'A']--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main424 m = new Main424();
        String s = "BBAAAB";
        int k = 3;
        System.out.println(m.characterReplacement(s, k));

    }
}
