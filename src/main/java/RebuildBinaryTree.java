import java.lang.reflect.Array;
import java.util.Arrays;

public class RebuildBinaryTree {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x;
      }

        /**
         * 关于树的题，最后都会归结到递归，毕竟左右子树，这个做法可以，但是第二个方法的取值很容易错
         * 很难懂好伐，为什么要i-startIn+startPre+1，这个我没看懂
         * @param pre
         * @param in
         * @return
         */
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            TreeNode treeNode = buildTree(pre,0,pre.length-1,
                    in,0,in.length-1);
            return  treeNode;
        }

        private TreeNode buildTree(int[] pre, int startPre, int endPre,
                                               int[] in,int startIn,int endIn){
            if(startPre > endPre || startIn > endIn){
                return null;
            }
            TreeNode root = new TreeNode(pre[startPre]);
            for(int i = startIn; i <= endIn; i++){
                if(in[i] == root.val){
                    root.left = buildTree(pre,startPre+1,startPre+i,in,startIn,i-1);
                    root.right = buildTree(pre,i-startIn+startPre+1,endPre, in,i+1,endIn);
                    break;
                }
            }
            return root;
        }

        /**
         * 一开始我想的是数组拷贝
         * 算法的健壮性也是算法的一部分，要注意特殊情况。
         * @param pre
         * @param in
         * @return
         */
        public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
            if(pre.length == 0){
                return null;
            }
            if(pre.length == 1){
                return new TreeNode(pre[0]);
            }
            /**
             * 先递归确定左右子树范围
             */
            TreeNode root = new TreeNode(pre[0]);
            int rootIndex = 0;
            for(int i = 0; i< in.length ; i++){
                if(in[i] == root.val){
                    rootIndex = i;
                    break;
                }
            }
            /**
             * 开始递归构建左右子树
             */
            root.left = reConstructBinaryTree2(Arrays.copyOfRange(pre,1,rootIndex+1),
                    Arrays.copyOfRange(in,0,rootIndex+1));
            root.right = reConstructBinaryTree2(Arrays.copyOfRange(pre,rootIndex+1,pre.length),
                    Arrays.copyOfRange(in,rootIndex+1,in.length));
            return  root;
        }

    }
}
