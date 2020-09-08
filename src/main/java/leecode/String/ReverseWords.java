package leecode.String;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWords {

    public String reverseWords2(String s) {
        String[] str = s.split(" ");

        for(int i = 0; i<str.length; i++){
            String temp = str[i];
            int left = 0;
            int right = temp.length()-1;
            char[] ch = temp.toCharArray();
            while(left < right){
                char c = ch[left];
                ch[left] = ch[right];
                ch[right] = c;
                left++;
                right--;
            }
            str[i] = String.valueOf(ch);
        }
        String res = str[0];
        for(int i = 1; i<str.length ; i++){
            res = res + " " + str[i];
        }
        return res;
    }

    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();

        res.append(reverseString(str[0]));
        for(int i = 1; i<str.length; i++){
            res.append(" "+reverseString(str[i]));
        }
        return res.toString();
    }

    private String reverseString2(String src) {
        int length = src.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = src.charAt(length - 1 - i);
            res.append(c);
        }
        return res.toString();
    }

    private String reverseString(String src) {
        int left = 0;
        int right = src.length()-1;
        char[] ch = src.toCharArray();
        while(left < right){
            char c = ch[left];
            ch[left] = ch[right];
            ch[right] = c;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

}
