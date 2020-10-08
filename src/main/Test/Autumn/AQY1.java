package Autumn;

import java.util.HashMap;
import java.util.Scanner;

public class AQY1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.print(solution(str));
    }

    public static int solution(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;
        int right = 0;
        while(right < str.length()){
            if(map.containsKey(str.charAt(right))){
                left = Math.max(map.get(str.charAt(right))+1,left);
            }
            len = Math.max(len,right-left+1);
            map.put(str.charAt(right),right);
            right++;
        }
        return len;
    }
}
