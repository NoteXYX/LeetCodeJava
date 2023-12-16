package com.leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Main49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> word2List = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            List<String> stringList = word2List.getOrDefault(str, new ArrayList<>());
            stringList.add(strs[i]);
            word2List.put(str, stringList);
        }
        return new ArrayList<>(word2List.values());
    }

}
