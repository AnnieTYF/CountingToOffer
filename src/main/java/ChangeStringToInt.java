import java.util.ArrayList;

public class ChangeStringToInt {
    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。数值为0或者字符串不是一个合法的数值则返回0
     *
     * 这道题难就难在，要判断整型的溢出
     */
    public static int StrToInt(String str) {
        if(str == null || str.equals("")){
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean isPositive = true;
        if(chars[0] == 45){
            isPositive = false;
        }
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<chars.length;i++){
            if(chars[i]>=48 && chars[i]<=57){
                array.add(chars[i]-48);
            }else if(chars[0] == 45 || chars[0] == 43){
                continue;
            }else{
                return 0;
            }
        }
        int num = 1;
        long sum = 0;
        for(int j = array.size()-1; j>=0;j--){
            sum = sum + array.get(j)*num;
            num *= 10;
        }
       if(sum > Integer.MAX_VALUE ){
           return 0;
       }else {
           return isPositive ? (int)sum : (int)sum * -1;
       }

    }

    /**
     * parseInt(String s, int radix)
     * 源码中的radix是用来判断进制的，但我们这里已经是十进制了
     * @param str
     * @return
     */
    public static int StrToInt2(String str) {
        if (str == null)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
       //判断超大值得溢出，因为int型不能溢出，所以要除以10（十进制），
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
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
                // Accumulating negatively avoids surprises near MAX_VALUE
                //确定数字的的十进制值
                digit = str.charAt(i++)-'0';//char转int
                //0到9以外的数字
                if (digit < 0 || digit > 9)
                    return 0;

                //判断超大数溢出，这里是为了保证下面计算不会超出最大值，因为int型，最大值就是2147483647
                if (result < multmin) {
                    return 0;
                }
                //result乘以基数（10）为得到位置
                result *= 10;
                //判断临界值的溢出
                //负数溢出时（String str = "-2147483649"）：result = -2147483640 limit = -2147483648 digit = 9
                //整数溢出时（String str = "2147483648"）：result = -214748364，limit = -2147483647 digit = 8
                if (result < limit + digit) {
                    return 0;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }

    public static void main(String args[]){
        String str = "2147483648";
        System.out.println(StrToInt2( str));
    }
}
