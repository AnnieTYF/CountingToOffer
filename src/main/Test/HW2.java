import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String match = in.next();
        String input = in.nextLine();
        System.out.print("FAIL");
        solution(input,match);
    }
    public static void solution(String input,String match){
        int start = 0; //前缀
        int left = 0; //[的位置
         for(int i = 0; i<input.length();i++){
             if(input.charAt(i) == '['){
                 left = i;
                 String title = input.substring(start,i-1);
                 if(title.equals(match)){
                     while(input.charAt(i) == ']'){
                         i++;
                     }
                     String sub = input.substring(left,i-1);
                     String[] content = sub.split(",");
                     for(int k = 0; k<content.length;k++){
                         String temp = content[k];
                         String[] value = temp.split("=");
                         System.out.print(value[1]);
                         System.out.print(" ");
                     }
                 }
             }
             start = i+1;
         }
    }
}
