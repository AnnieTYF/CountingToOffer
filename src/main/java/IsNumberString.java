public class IsNumberString {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     */
    /**
     * 解法一：正则表达
     * 以下对正则进行解释:
     * [\\+\\-]?            -> 正或负符号出现与否
     * \\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
     *                         否则一起不出现
     * ([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
     *                         紧接着必须跟着整数；或者整个部分都不出现
     */
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
    /**
     * 解法二：情况判断
     * 首先要分析一共有几条规则,根据那些不合法的举例来看：
     * 1.12e说明e的后面必须有数字，不能有两个e
     * 2. +-5说明符号位要么出现一次在首位，要么出现一次在e的后一位，其他地方都不能有
     * 3. 12e+4.3说明e的后面不能有小数，1.2.3说明不能有两个小数点
     * 4. 1a3.14说明不能有其他的非法字符，比如这里的a
     * 14ms
     */
    private int index = 0;
    // 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是
    // 整数（可以有正负号，也可以没有），而B是一个无符号整数
    public boolean isNumeric2(char[] str) {
       if(str.length<1){
           return false;
       }
       boolean flag = scanInteget(str);
        // 如果出现'.'，接下来是数字的小数部分
       if(index < str.length && str[index] == '.'){
           index++;
           /**
            * 用||的原因:
            * 1. 小数可以没有整数部分，例如.123等于0.123
            * 2. 小数点后面可以没有数字，例如233.等于233.0
            * 3. 当然小数点前面和后面可以有数字，例如233.666
            * 小数点后是否有整数 || 小数点前有整数
            */
           flag = scanUnsignedInteger(str) || flag;
       }
        // 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
       if(index < str.length && (str[index] == 'E' || str[index] == 'e')){
         index++;
           /**
            * 用&&的原因：
            * 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1
            * 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            * e或E前面没有数字是否有整数 && e或E后面是否整数
            */
         flag = flag && scanInteget(str);
       }
       //是否扫描完整个字符串
       return flag && index == str.length;
    }

    //判断整数的符号，有就跳过
    private boolean scanInteget(char[] str){
        if(index < str.length && (str[index] == '+' || str[index] == '-')){
           index++;
        }
        return scanUnsignedInteger(str);
    }
    //判断有没有0-9整数
    private boolean scanUnsignedInteger(char[] str){
         int start = index;
         while(index < str.length && str[index] >= '0' && str[index] <='9'){
             index++;
         }
        // 当str中存在若干0-9的数字时，返回true
         return start<index;
    }
}
