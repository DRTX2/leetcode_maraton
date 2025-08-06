package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num: nums1)
            map.put(num,map.getOrDefault(num,0)+1);
        for (int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                result.add(num);
                map.put(num, map.get(num)-1); // to add just the neccesary times that number
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
