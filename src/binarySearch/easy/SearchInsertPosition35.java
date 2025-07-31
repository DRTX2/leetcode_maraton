package binarySearch.easy;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid=-1;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                l=mid+1;
            else
                r = mid-1;
        }
        return target<nums[mid]?mid:mid+1;
    }
}
