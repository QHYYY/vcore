package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/12/9　10:59
 * @ClassName:three
 */
public class Three {

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int length = s.length();
        int start = 0;
        int res = 0;
        for (int i = 0; i < length; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }
        return res;
    }

    //    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        if (chars.length == 0) return 0;
//        int length = 1;
//        int index = 0;
//        char lastChar = 0;
//        Map<Character, Integer> map = new HashMap();
//        for (int i = 0; i < chars.length; i++) {
//            if (map.get(chars[i]) == null) {
//                map.put(chars[i], i);
//                length = Math.max(map.size(), length);
//            } else {
//                if (lastChar == chars[i]) {
//                    map.clear();
//                    map.put(chars[i], i);
//                }
//                lastChar = chars[i];
//                index++;
//                i = index;
//                map.clear();
//                map.put(chars[i], i);
//            }
//        }
//        map.clear();
//        for (int i = chars.length - 1; i > 0; i--) {
//            if (map.get(chars[i]) == null) {
//                map.put(chars[i], i);
//                length = Math.max(map.size(), length);
//            } else {
//                if (lastChar == chars[i]) {
//                    map.clear();
//                    map.put(chars[i], i);
//                }
//                lastChar = chars[i];
//                index--;
//                i = index;
//                map.clear();
//                map.put(chars[i], i);
//            }
//        }
//        return length;
//    }
    public static void main(String[] args) {
        //kwkwc "ckilbkd" "ohomm"
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
