package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/12/11　13:32
 * @ClassName:Five
 */
public class Five {
    public static String longestPalindrome(String s) {
        int[] last = new int[128];
        String result = null;
        int start = 0;
        int res = 0;
        int lastRes = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            if (res != lastRes) {
                result = s.substring(start, start + res);
            }
            last[index] = i + 1;
            lastRes = res;
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Integer, Character> selectMap = new HashMap<Integer, Character>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            selectMap.put(i, chars[i]);
            if (s.contains(String.valueOf(chars[i]))) {
                Integer integer = map.get(chars[i]);
                if (integer == 0) {
                    map.put(chars[i], 1);
                } else {
                    map.put(chars[i], integer + 1);
                }
            }
        }
            Collection<Integer> values = map.values();
            Object[] objects = values.toArray();
            Arrays.sort(objects);

        return "";

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
