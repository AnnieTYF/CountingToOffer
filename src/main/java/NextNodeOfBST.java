public class NextNodeOfBST {
    /**
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        //父节点
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解题思路：有2种情况
     * 1. 该节点有右子树，则下一个节点是右子树的最左节点
     * 2. 该节点没有右子树,则判断它有没有父节点,并判断当前节点是不是父节点的左节点，不是就往上遍历
     * 如果一直找到根还是找不到，那就返回null
     *  27ms
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
           return pNode;
        }
        //如果有右子树，则找右子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                 pNode = pNode.left;
            }
            return pNode;
        }
        //没右子树，则找第一个当前节点是父节点左孩子的节点
            while(pNode.next != null ){
                if(pNode.next.left == pNode){
                    return pNode.next;
                }
                pNode = pNode.next;
            }
           //退到了根节点仍没找到，则返回null
        return null;
    }

}
