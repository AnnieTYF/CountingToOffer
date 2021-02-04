package leecode.String;

import java.util.ArrayList;

public class RepeatedSubstringPattern {
    //双倍字符串
    public boolean repeatedSubstringPattern(String s) {
       String str = s + s;
       if(str.substring(1,str.length()-1).contains(s)){
           return true;
       }
        return false;
    }
}
