package Autumn;

import java.util.Scanner;

public class WY {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long len = in.nextLong();
        long ans = 0;
        for(long i = 0; i<len;i++){
            ans += in.nextLong()/2;
        }
        System.out.println(ans);
    }
}
