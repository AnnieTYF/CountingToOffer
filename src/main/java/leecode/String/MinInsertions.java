package leecode.String;

import java.util.Scanner;

public class MinInsertions {

    public static int minInsertions(String s) {
        int res = 0;
        int need = 0; //需要的右括号数
        for(int i = 0; i<s.length() ; i++){
            if(s.charAt(i) == '('){
                need+=2;
                //当遇到左括号时，若对右括号的需求量为奇数，需要插入 1 个右括号
                if(need % 2 == 1){
                    res++; // 插入一个右括号
                    need--;// 对右括号的需求减一
                }
            }
            if(s.charAt(i) == ')'){
               need--;
               //单个右括号，无左括号情况
               if(need < 0){
                  //需要插入一个左括号
                   res++;
                   // 同时，对右括号的需求变为 1
                   need = 1;
               }
            }
        }
        return res + need;
    }

    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minInsertions(s));
    }
}
