package leecode.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    /**
     * 栈和不反转字符串
     * 解决 - 结合律的问题的一个非常简单的方法就是使将 - 运算符看作右侧操作数的大小。一旦我们将 -
     * 看作操作数的大小，则表达式将只剩下一个操作符。就是 + 运算符，而 + 是遵循结合律的。
     * 例如，A-B-CA−B−C 等于 A + (-B) + (-C)A+(−B)+(−C)。
     * 重写以后的表达式将遵循结合律，所以我们从左或从右计算表达式都是正确的。
     * 我们需要注意的是给定的表达式会很复杂，即会有嵌套在其他表达式的表达式。即 (A - (B - C))，我们需要 B-C 外面的 - 号与
     * B-C 关联起来，而不是仅仅与 B 关联起来。
     * / 我们可以通过遵循前面的基本练习并将符号与其右侧的表达式关联来解决此问题。
     * 然而，我们将采用的方法有一个小的转折，因为我们将在运行中评估大多数表达式。这减少了推送和弹出操作的数量。
     *
     * 算法：
     * 1. 正序迭代字符串
     * 2. 操作数可以由多个字符组成，字符串 "123" 表示数字 123，它可以被构造为：123 >> 120 + 3 >> 100 + 20+ 3。
     * 如果我们读取的字符是一个数字，则我们要将先前形成的操作数乘以 10 并于读取的数字相加，形成操作数。
     * 3. 每当我们遇到 + 或 - 运算符时，我们首先将表达式求值到左边，然后将正负符号保存到下一次求值
     * 4. 如果字符是左括号 (，我们将迄今为止计算的结果和符号添加到栈上，然后重新开始进行计算，就像计算一个新的表达式一样。
     * 5. 如果字符是右括号 )，则首先计算左侧的表达式。则产生的结果就是刚刚结束的子表达式的结果。如果栈顶部有符号，则将此结果与符号相乘。
     */
    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0; //记录算式中的数字
        int result = 0;
        int sign = 1;  // 1 表示 + 号, -1 表示 - 号

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 如果是数字，连续读取到 num
                operand = 10 * operand + (ch - '0');
            } else if (ch == '+') {
                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;
                // Save the recently encountered '+' sign
                sign = 1;
                // Reset operand
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (ch == '(') {
                // Push the result and sign on to the stack, for later
                stack.push(result);
                stack.push(sign);
                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;
            } else if (ch == ')') {
               // 如果字符是右括号 )，则首先计算左侧的表达式。则产生的结果就是刚刚结束的子表达式的结果。
                result += sign * operand;
                //如果栈顶部有符号，则将此结果与符号相乘。
                result *= stack.pop();
                result += stack.pop();
                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }

    public static void main(String args[]) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s) );
    }

    public int calculate2(String s) {
        String[] polish = getPolish(s); //转后缀表达式
        return evalRPN(polish);
    }

    //中缀表达式转后缀表达式
    private String[] getPolish(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        int n = array.length;
        int temp = -1; //累加数字，-1 表示当前没有数字
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') {
                continue;
            }
            //遇到数字
            if (Character.isDigit(array[i])) {
                //进行数字的累加
                if (temp == -1) {
                    temp = array[i] - '0';
                } else {
                    temp = temp * 10 + array[i] - '0';
                }
            } else {
                //遇到其它操作符，将数字加入到结果中
                if (temp != -1) {
                    res.add(temp + "");
                    temp = -1;
                }
                if (isOperation(array[i] + "")) {
                    //遇到操作符将栈中的操作符加入到结果中
                    while (!stack.isEmpty()) {
                        //遇到左括号结束
                        if (stack.peek().equals("(")) {
                            break;
                        }
                        res.add(stack.pop());
                    }
                    //当前操作符入栈
                    stack.push(array[i] + "");
                } else {
                    //遇到左括号，直接入栈
                    if (array[i] == '(') {
                        stack.push(array[i] + "");
                    }
                    //遇到右括号，将出栈元素加入到结果中，直到遇到左括号
                    if (array[i] == ')') {
                        while (!stack.peek().equals("(")) {
                            res.add(stack.pop());
                        }
                        //左括号出栈
                        stack.pop();
                    }

                }
            }
        }
        //如果有数字，将数字加入到结果
        if (temp != -1) {
            res.add(temp + "");
        }
        //栈中的其他元素加入到结果
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        String[] sArray = new String[res.size()];
        //List 转为 数组
        for (int i = 0; i < res.size(); i++) {
            sArray[i] = res.get(i);
        }
        return sArray;
    }
    // 下边是 150 题的代码，求后缀表达式的值
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (isOperation(t)) {
                int a = stringToNumber(stack.pop());
                int b = stringToNumber(stack.pop());
                int ans = eval(b, a, t.charAt(0));
                stack.push(ans + "");
            } else {
                stack.push(t);
            }
        }
        return stringToNumber(stack.pop());
    }
    private int eval(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
    private int stringToNumber(String s) {
        int sign = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            start = 1;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res * sign;
    }
    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
