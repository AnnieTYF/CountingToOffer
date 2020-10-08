package Autumn;

import java.util.Scanner;

public class Di1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        System.out.print(solution(ch,n));
    }

    public static String solution( char[] ch, int n){
        if(ch.length == 0){
            return "";
        }
        if(n >= ch.length){
            reverse(ch,0,ch.length-1);
        }else{
            int index = 0;
            while(index < ch.length){
                int i = index;
                int j = index+n-1;
                if(j < ch.length){
                    reverse(ch,i,j);
                }else{
                    reverse(ch,i,ch.length-1);
                }
                index += n;
            }
        }
        return String.valueOf(ch);
    }

    public static void reverse(char[] ch, int i, int j){
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}
