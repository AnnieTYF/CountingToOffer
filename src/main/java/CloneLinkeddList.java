public class CloneLinkeddList {
    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 这题我不会，直接看解析
     *  1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
     * 2、遍历链表，A1->random = A->random->next;
     * 3、将链表拆分成原链表和复制后的链表
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
         if(pHead == null){
             return null;
         }
        RandomListNode curNode  = pHead;
         //复制每个节点
        while(curNode!=null){
            RandomListNode newNode = new RandomListNode(curNode.label) ;
            RandomListNode temp = curNode.next;
            curNode.next = newNode;
            newNode.next = temp;
            curNode = temp;
        }
        //遍历链表
        curNode = pHead;
        while(curNode!=null){
            curNode.next.random = curNode.random == null ? null:curNode.random.next;
            curNode = curNode.next.next;
        }
        //将链表拆分成原链表和复制后的链表
        curNode = pHead;
        //这里把头节点专门摘了出来，后面的链表结构不变
        RandomListNode pCloneHead = pHead.next;
        while(curNode!=null){
            RandomListNode cloneNode = curNode.next;
            curNode.next = cloneNode.next;
            //这里的逻辑要注意一下，尤其是人家判断null的方式
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            curNode = curNode.next;
        }
        return pCloneHead;
    }
}
