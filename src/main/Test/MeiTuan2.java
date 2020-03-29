import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MeiTuan2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int num = Integer.parseInt(data);
        String data2 = sc.nextLine();
        String[] half = data2.split(" ");
        String str = null;
        for(int i = 0; i<num;i++){
            str += half[i];
        }
        ArrayList<String> subString = new ArrayList<>();
        if(str != null){
             PermutationHelper(str.toCharArray(),0, subString);
        }
        int count = 0;
        for(String sub : subString){
            boolean flag = true;
           for(int i = 0; i< sub.length();i++){
               if(i%(sub.charAt(i)-'0') != 0){
                  flag = false;
               }
           }
           if(flag){
               count++;
           }
        }
        System.out.print(count);
    }

    private static void PermutationHelper(char[] chars, int i, ArrayList<String> result){
        if(i == chars.length-1){
            String val = String.valueOf(chars);

            if(!result.contains(val)){
                result.add(val);
            }
        }else{
            for(int j = i;j<chars.length;j++){
                swap(chars,i,j);
                PermutationHelper(chars,i+1,result);
                //复位
                swap(chars,i,j);
            }
        }
    }

    private static void swap(char[] chars,int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
/**
 * 3. 解题思路：将三组射击转化为二进制，1的位置代表射中，有多少个1就是射中多少次，最后乘以总的概率（p/q）
 */
}
