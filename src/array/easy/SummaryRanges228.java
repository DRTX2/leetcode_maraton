package array.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    /*
    *
You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
    * *
    * **/
    public List<String> summaryRanges(int[] nums) {
        final List<String> ranges = new ArrayList<>();
        if(nums==null || nums.length==0) return ranges;

        int start = 0;
        for (int i = 1; i <= nums.length; i++) {
            if(i==nums.length || nums[i] != nums[i-1]+1){
                if(start==nums[i-1]){
                    ranges.add(String.valueOf(start));
                }else{
                    ranges.add(start+"->"+nums[i-1]);
                }
                if(i<nums.length) start=nums[i];
            }
        }
        return ranges;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < nums.length) {
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] - nums[j] == 1) j++;
            sb.append(nums[i]);
            sb.append("->");
            sb.append(nums[j]);
            if (j == i) res.add(String.valueOf(nums[i]));
            else res.add(sb.toString());
            i = j + 1;
            sb.setLength(0);
        }
        return res;
    }
}
