public class PostorderBinaryTree {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     *
     * 解题思路：*
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     */

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int temp = start;
        while (temp <= end && sequence[temp] < root) {
            temp++;
        }
        for (int i = temp; i <= end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return verify(sequence, start, temp - 1) && verify(sequence, temp, end - 1);
    }
}
