package binaryTree.easy;

import structures.TreeNode;

public class SortedArrayToBST108 {//* to binary search
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    public TreeNode convert(int[] nums, int left, int right){
        if(left>right) return null;

        int mid = left +(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convert(nums, left, mid-1);
        node.right = convert(nums, mid+1, right);
        return node;
    }
}
