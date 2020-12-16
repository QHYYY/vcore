package leetcode;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/12/11　13:32
 * @ClassName:Five
 */
public class Five {
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.equalsIgnoreCase(" ")) return "";

        char[] chars = s.toCharArray();
        int[] result = new int[2];
        for (int i = 0; i < chars.length; i++) {
            i = findLongest(i, chars, result);
        }
        return s.substring(result[0], result[1] + 1);
    }

    public static int findLongest(int low, char[] chars, int[] result) {
        int high = low;
        while (high < chars.length - 1 && chars[low] == chars[high + 1]) {
            high = high + 1;
        }
        int ans = high;
        while (low > 0 && high < chars.length - 1 && chars[low-1] == chars[high+1]) {
            low--;
            high++;
        }
        if (high - low > result[1] - result[0]) {
            result[0] = low;
            result[1] = high;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbdccbabc"));
    }
}
