package leecode.Tree;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findMax(nums,0, nums.length-1);
    }
    /* 将 nums[lo..hi] 构造成符合条件的树，返回根节点 */
    public TreeNode findMax(int[] nums,int left, int right){
        // base case
        if(left>right){
            return null;
        }
        // 找到数组中的最大值和对应的索引
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for(int i = left; i<= right; i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                index=i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = findMax(nums,left,index-1);
        root.right = findMax(nums,index+1,right);
        return root;
    }
}
