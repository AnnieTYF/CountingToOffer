package Autumn;

import java.util.Scanner;

public class AL1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long len = in.nextLong();
        String a = in.nextLine();
        String b = in.nextLine();
        solution(len,a,b);
    }

    public static void solution(long len,String a, String b){
         int count = 0;
         int min = 0;
         String str = method(a);
         for(int i = 0; i<len ; i++) {
             if (str.charAt(i) != b.charAt(i)) {
                 count++;
             }
         }
             min = count/2 + count%2+1;
             count = 0;
             for(int i = 0; i<len ; i++) {
                 if (a.charAt(i) != b.charAt(i)) {
                     count++;
                 }
             }
             min = Math.min(min,count/2+count%2+1);
                 count = 0;
                 String bfz = method(b);
                 for(int i = 0; i<len ; i++){
                     if(bfz.charAt(i) != b.charAt(i)){
                         count++;
                     }
         }
    }

    public static String method(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
