package twoPointers.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays349 {
    // Given two integer arrays nums1 and nums2, return an array of their intersection.
    // Each element in the result must be unique and you may return the result in any order.
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers2 = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for(int n: nums2)
            numbers2.add(n);
        for(int n: nums1)
            if(numbers2.contains(n)) ans.add(n);
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        var nums = new int[]{1,2,2,1};
        var nums2 = new int[]{2,2};
        System.out.println(intersection(nums,nums2) );

    }
}
