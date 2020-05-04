package leecode.String;

import java.util.HashMap;
import java.util.Stack;

public class IsValidBraces {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     */
    public boolean isValid(String s) {
        if(s.length() % 2 == 1){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        //开括号
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            //如果遇到闭括号，检查栈顶的元素。
            // 如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
            if(map.containsKey(ch)){
                 char top = stack.isEmpty()?'#':stack.pop();
                 if(top != map.get(ch)){
                    return false;
                 }
            }else{
                //如果遇到开括号，只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式
                stack.push(ch);
            }
        }
        return stack.empty();
    }
}
