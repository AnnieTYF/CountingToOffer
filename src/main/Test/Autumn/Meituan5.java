package Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Meituan5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
    }

    public static void solution(int n){
        while(true) {
            int[] a = new int[20];
            int len = 0, i, b = 0;
            // flag为true表示是“重复数”，为false表示表示是“不重复数”
            boolean flag = false;
            // 将n的各位上数字存到数组a中
            while(n >= 0) {
                a[len++] = n % 10;
                n = n / 10;
            }
            // 从高位开始遍历是否有重复位
            for(i = len - 1; i > 0; i--) {
                // 有重复位则次高位加1（最高位有可能进位但这里不需要额外处理）
                if(a[i] == a[i - 1] && !flag) {
                    a[i - 1]++;
                    flag = true;
                }
                else if(flag) {
                    // 将重复位后面的位置为0101...形式
                    a[i - 1] = b;
                    b = (b == 0) ? 1 : 0;
                }
            }
            // 重组各位数字为n，如果是“不重复数”则输出退出否则继续判断
            for(i = len - 1; i >= 0; i--) {
                n = n * 10 + a[i];
            }
            if(!flag) {
                System.out.println(n);
                break;
            }
        }
    }
}
