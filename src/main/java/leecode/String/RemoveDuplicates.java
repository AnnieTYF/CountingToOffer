package leecode.String;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();

        for (char ch : S.toCharArray()) {
            if (stack.isEmpty() || ch != stack.peek()) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        for (char s : stack) {
            str.append(s);
        }
        return str.toString();
    }
}
