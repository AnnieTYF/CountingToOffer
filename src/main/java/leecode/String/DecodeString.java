package leecode.String;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 输入：s = "3[a2[c]]"
 *  输出："accaccacc"
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        //乘数
        int multi = 0;
        LinkedList<Integer> stack_num = new LinkedList<>();
        LinkedList<String> stack_str = new LinkedList<>();
        //构建辅助栈 stack， 遍历字符串 s 中每个字符 c
        for(Character c : s.toCharArray()) {
            //当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 0
            if(c == '[') {
                stack_num.addLast(multi);
                stack_str.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            //当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res
            //last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a
            //cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_num.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_str.removeLast() + tmp);
            }
            //当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算
            //因为字符串可能超过 10 ，所以multi* 10 ， "12" = 10 * '1' + '2' = multi * '1' + '2'
            else if(c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
