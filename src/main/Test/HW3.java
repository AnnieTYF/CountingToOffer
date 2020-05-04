import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {

        solution(9999);
    }

    public static void solution(int x){
        int countx = 0;
        while(x != 0){
           countx++;
           x = x&(x-1);
        }
        System.out.println(countx);
    }
}
