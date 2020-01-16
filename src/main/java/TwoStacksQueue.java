import java.util.Stack;

public class TwoStacksQueue {
    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int num;

    public void push(int node) {
        //这里要特别注意，因为不加这个判断的话，如果push和pop命令数量不等，输出就会有错，不再是队列了
        //每次再添加一个数前，一定要判断另一个栈中有没有剩余的数，有就再push回来，这样才能一直保证队列
        //例：push1，push2,push3,pop,pop,push4,pop
        while(!stack2.empty()){
            num = stack2.pop();
            stack1.push(num);
        }
        stack1.push(node);
    }
    public int pop() {
        while(!stack1.empty()){
            num = stack1.pop();
            stack2.push(num);
        }
        return stack2.pop();
    }

    /**
     * 这里有一个更好的方法，不需要把栈2的内容再倒回栈1中
     * 直接保持栈1是输入，栈2是输出，pop时只要栈2不为空，就将栈2输出，不需要将栈1pop到栈2
     */
    public void push2(int node) {
        stack1.push(node);
    }

    public int pop2() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
