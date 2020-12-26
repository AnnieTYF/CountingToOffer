package leecode.Tree;

public class BuildTree {
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build2(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    public TreeNode build2(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        // base case
        if(preStart>preEnd){
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-inStart;
        // 递归构造左右子树
        root.left = build(preorder,preStart+1,preStart+leftSize,
                inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,
                inorder,index+1,inEnd);
        return root;
    }
   //从中序与后序遍历序列构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd){
        // base case
        if(inStart>inEnd){
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index-inStart;
        // 递归构造左右子树
        root.left = build(inorder,inStart,index-1,
                postorder,postStart,postStart+leftSize-1);
        root.right = build(inorder,index+1,inEnd,
                postorder,postStart+leftSize,postEnd-1);
        return root;
    }

}
