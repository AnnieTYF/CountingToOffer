package leecode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    /**
     *给定一个完美二叉树填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     */
    public Node connect(Node root) {
         if(root == null){
             return root;
         }
        Queue<Node> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i = 0; i<size ; i++){
                 Node node = queue.poll();
                 if (i < size - 1) {
                     node.next = queue.peek();
                 }
                 if(node.left != null){
                     queue.offer(node.left);
                 }
                 if(node.right != null){
                     queue .offer(node.right);
                 }
             }
         }
         return root;
    }
}
