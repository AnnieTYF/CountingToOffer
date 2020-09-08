package Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meituan1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        solution(num);
    }

    public static void solution(long num){
        int res = 0;
        List<String> list = new ArrayList<>();
        for(long i = 1; i<=num ; i++){
            long mul = i*4;
            String str1 = mul+"";
            String str2 = i+ "";
                int len = str2.length();
                boolean flag = true;
                int j = 0;
                for(j = 0; j<len ; j++){
                    if(str1.charAt(j) == 0){
                        continue;
                    }
                    if (str1.charAt(j) != str2.charAt(len-1-j)){
                        flag = false;
                        break;
                    }
                }
                if(flag && j == len){
                    res++;
                    list.add(i + " " + mul);
                }
        }
        System.out.println(res);
        for(String str : list){
            System.out.println(str);
        }
    }
    public static void solution2(long num){
        int res = 0;
        List<String> list = new ArrayList<>();
        for(long i = 1; i<=num ; i++){
            long mul = i*4;
            StringBuilder sb = new StringBuilder(mul+"");
            String str1 = sb.reverse().toString();
            String str2 = i+ "";
            if(str1.equals(str2)){
                res++;
                list.add(i + " " + mul);
            }
        }
        System.out.println(res);
        for(String str : list){
            System.out.println(str);
        }
    }

}
