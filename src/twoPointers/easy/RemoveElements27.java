package twoPointers.easy;

public class RemoveElements27 {
    public static int removeElement(int[] nums, int val) {
        int index =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val)
                nums[index++]=nums[i];
        }
        return index;
    }

    public static void main(String[] args) {
        var numbers=new int[]{3,2,2,3};
        int n = removeElement(numbers,3);
        System.out.println("");
        for(int num: numbers)
            System.out.print(num+" ");
        System.out.println(n);
    }
}
