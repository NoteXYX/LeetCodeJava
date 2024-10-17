package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main93_FuYuanIP {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        addRes(res, s, "", 1);
        return res;
    }

    private void addRes(List<String> res, String source, String target, int segment) {
        if (segment == 4) {
            if (source.length() < 1 || source.length() > 3 || (source.length() > 1 && source.startsWith("0")) || Integer.parseInt(source) > 255) {
                return;
            }
            target += source;
            res.add(target);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i >= source.length()) {
                break;
            }
            String currentSegment = source.substring(0, i);
            if (i > 1 && currentSegment.startsWith("0")) {
                break;
            }
            if (i == 3 && Integer.parseInt(currentSegment) > 255) {
                break;
            }
            String newTarget = target + currentSegment + ".";
            addRes(res, source.substring(i), newTarget, segment + 1);
        }
    }

    public static void main(String[] args) {
        Main93_FuYuanIP main = new Main93_FuYuanIP();
        String s = "25525511135";
        System.out.println(main.restoreIpAddresses(s));
    }
}
