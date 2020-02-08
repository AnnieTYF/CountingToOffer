import java.util.Stack;

public class ReverseSentences {
    /**
     * 翻转单词顺溪
     * 例如：“student. a am I”正确的句子应该是“I am a student.”
     */
    /**
     * 解法一：栈，注意字符串的判空
     * 24ms
     * @param str
     * @return
     */
    public static String ReverseSentence(String str) {
        //trim() 方法用于删除字符串的头尾空白符
        if(str.trim().equals("")){
            return str;
        }
        Stack<String> stack = new Stack<>();
        for(String s : str.split(" ")){
          stack.push(s);
        }
        String result =stack.pop();
        while(!stack.isEmpty()){
            result  = result + " "+ stack.pop();
        }
     return result;
    }

    /**
     * 解法二：split + stringbuffer的append方法
     * 24ms
     * @param str
     * @return
     */
    public static String ReverseSentence2(String str) {
        //trim() 方法用于删除字符串的头尾空白符
        if(str.trim().equals("")){
            return str;
        }
       String[] strings = str.split(" ");
       StringBuffer buffer = new StringBuffer();
       for(int i = strings.length -1; i>=0;i--){
           buffer.append(strings[i]);
           if (i>0){
               buffer.append(" ");
           }
       }
        return new String(buffer);
    }

    /**
     *解法三：反转字符串，就跟上一道左旋转字符串题的核心思想一样,这应该是正规解法，嘻
     * 先翻转整个句子，然后，依次翻转每个单词。
     * 依据空格来确定单词的起始和终止位置
     * 28ms
     */
    public static String ReverseSentence3(String str) {
        //trim() 方法用于删除字符串的头尾空白符
        if(str.trim().equals("")){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,str.length()-1);
        int blank = -1;
        for(int i = 0; i<str.length();i++){
           if(chars[i] == ' '){
               int nextBlank = i;
               reverse(chars,blank+1,nextBlank-1);
               blank = nextBlank;
           }
        }
        //最后一个单词单独进行反转
        reverse(chars,blank + 1,chars.length - 1);
        return new String(chars);
    }
    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String args[]){
        String str = "I am a student.";
        System.out.println(ReverseSentence3(str));
    }
}
