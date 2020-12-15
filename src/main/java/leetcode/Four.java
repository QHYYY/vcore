package leetcode;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * @Description:TODO
 * @Author:qihaoyuan
 * @Date:Create：in2020/12/11　10:59
 * @ClassName:Four
 */
public class Four {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            return Double.valueOf(list.get(list.size() / 2));
        } else {
            return (double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {0,0};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
