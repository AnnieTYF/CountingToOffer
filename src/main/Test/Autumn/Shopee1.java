package Autumn;

import java.util.Scanner;

public class Shopee1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str){
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        boolean flag = false;
        int j = 0;
        while(!Character.isLetterOrDigit(chs[j])){
            j++;
        }
        for(int i = j; i<chs.length ;i++){
            char ch = chs[i];
            if(Character.isLetterOrDigit(ch)){
                char temp;
                if(flag){
                    temp = Character.toUpperCase(ch);
                }else{
                    temp = Character.toLowerCase(ch);
                }
                sb.append(temp);
                flag = false;
            }else{
                flag = true;
            }
        }
        return sb.toString();
    }
}
