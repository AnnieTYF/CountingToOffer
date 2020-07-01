package leecode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return null;
        }
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        StringBuilder trace = new StringBuilder();
        backtrace(0,0,n,trace,res);
        return res;
    }

    public static void backtrace(int left, int right, int max,StringBuilder trace,List<String> res){
        if(trace.length() == 2*max){
            res.add(trace.toString());
            return;
        }
        //这里不用for循环选择了，因为总共就两个选择，左括号和右括号
        //尝试放一个左括号
        if(left < max){
            trace.append('(');
            backtrace(left+1,right,max,trace,res);
            trace.deleteCharAt(trace.length()-1);
        }
        //尝试放一个右括号,因为左括号 》= 右括号才合法
        if(right < left){
            trace.append(')');
            backtrace(left,right+1,max,trace,res);
            trace.deleteCharAt(trace.length()-1);
        }
    }

    public static void main(String args[]){
      //  System.out.println(generateParenthesis(3));
    }

}
