package com.leetcode;

/**
 * 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 */
public class Main165 {
    public int compareVersion(String version1, String version2) {
        String[] num1 = version1.split("\\.");
        String[] num2 = version2.split("\\.");
        int len1 = num1.length;
        int len2 = num2.length;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int v1 = i < len1 ? Integer.parseInt(num1[i]) : 0;
            int v2 = i < len2 ? Integer.parseInt(num2[i]) : 0;
            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }
        }
        return 0;
    }
}
