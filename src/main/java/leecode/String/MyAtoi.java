package leecode.String;

public class MyAtoi {
    /**
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响
     */
    public int myAtoi2(String str) {
        if (str == null)
            return 0;
         str = str.trim();
        int result = 0; //最终结果
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit; //单个数值

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位，判断是不是正负号
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                    // 不是负号也不是加号则抛出异常
                } else if (firstChar != '+')
                    return 0;
                //如果有符号（加号或者减号）且字符串长度为1，则抛出异常
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                //确定数字的的十进制值
                digit = Character.digit(str.charAt(i++), 10);//char转int
                //0到9以外的数字
                if (digit < 0 )
                    //这里按照题意做一点修改
                    return negative ? result : -result;;
                //判断超大数溢出，这里是为了保证下面计算不会超出最大值，因为int型，最大值就是2147483647
                if (result < multmin) {
                    //这里按照题意做一点修改
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //result乘以基数（10）为得到位置
                result *= 10;
                //判断临界值的溢出
                //负数溢出时（String str = "-2147483649"）：result = -2147483640 limit = -2147483648 digit = 9
                //整数溢出时（String str = "2147483648"）：result = -214748364，limit = -2147483647 digit = 8
                if (result < limit + digit) {
                    //如果是负数溢出，就用最小值，如果是正数溢出，就用最大值
                    return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }

    /**
     * 解法二：有限状态机
     * {"start",{"start","sign","innum","end"}},
     *             {"sign",{"end","end","innum","end"}},
     *             {"innum",{"end","end","innum","end"}},
     *             {"end",{"end","end","end","end"}}
     * start -> 0
     * sign -> 1
     * innum -> 2
     * end -> 3
     */
    class Automaton {
        private int state = 0;
        private int[][] tables = {{0, 1, 2, 3}, {3, 3, 2, 3}, {3, 3, 2, 3}, {3, 3, 3, 3}};
        long ans = 0;
        int sign = 1;

        public int gets(char c){
            if(c==' ')return 0;
            if(c=='+'||c=='-')return 1;
            if(Character.isDigit(c))return 2;
            return 3;
        }

        public void get(char c){
            state = tables[state][gets(c)];
            if(state == 2){
                ans=ans*10+(c-'0');
                ans= sign==1 ? Math.min(ans,Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MIN_VALUE);
            }else if(state == 1){
                sign = c == '+' ? 1 : -1;
            }
        }
    }
    public int myAtoi(String str) {
         Automaton automaton = new Automaton();
         char[] chs = str.toCharArray();
         for(char ch : chs){
             automaton.get(ch);
         }
         return automaton.sign * (int)automaton.ans;
    }

}
