package leecode.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expand {

    static List<String> res;
    public static String[] expand(String S) {
        if (S.indexOf("{") < 0) {
            String[] str = {S};
            return str;
        }
        res = new ArrayList<>();
        backtrace(S,new StringBuilder(),0);
        Collections.sort(res);
        return res.toArray(new String[res.size()]);
    }

    public static void backtrace(String s, StringBuilder sb, int index){
        if(index == s.length()){
           res.add(sb.toString());
           return;
        }
        //在遍历的过程中遇到{}包围起来的就挨个字符回溯,
        if(s.charAt(index) == '{'){
            //先计算出{}中内容的长度count
             int count = 0;
             for(int j = index+1; s.charAt(j) != '}';j++){
                 count++;
             }
            //下次要跳转的位置就为index+count+2，+2是因为有花括号占2个位
            for(int j = index+1; s.charAt(j) != '}';j++){
                char ch = s.charAt(j);
                //当然要去掉’,‘这个字符
                if(ch != ','){
                    sb.append(ch);
                    backtrace(s,sb,index+count+2);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }else{
            //遇到括号外的其他字符
            sb.append(s.charAt(index));
            backtrace(s,sb,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        String str = "{a,b}c{d,e}f";

        System.out.print(expand(str));
    }
}
