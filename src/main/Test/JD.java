import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class JD {
/*public class Rect{
    int h = 0;
    int w = 0;
    public Rect(int w,int h) {
        this.w = w;
        this.h = h;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}*/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //测试组数
        int num = in.nextInt();
        for(int i = 0; i<num ;i++){
            int [] h = new int[6];
            int[] w = new int[6];
            for(int j = 0 ;j<6 ; j++){
                int hIn = in.nextInt();
                int wIn = in.nextInt();
                h[j] = Math.max(hIn,wIn);
                w[j] = (Math.min(hIn,wIn));
            }
            solution(h,w);
        }
    }
    public static void solution(int[] h , int[] w){
       boolean  flag = true;
       int temp = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<h.length;i++){
            for(int j = 0; j<h.length-1-i;j++){
                if(h[j] < h[j+1]){
                    temp = h[j];
                    h[j] = h[j+1];
                    h[j+1] = temp;
                    temp = w[j];
                    w[j] = w[j+1];
                    w[j+1] = temp;
                }
                if(h[j] == h[j+1] && w[j] < w[j+1]){
                    temp = w[j];
                    w[j] = w[j+1];
                    w[j+1] = temp;
                }
            }
        }
        if(h[0] != h[1] || w[0] != w[1]){
            flag = false;
        }
        if(h[2] != h[3]|| w[2] != w[3]){
            flag = false;
        }
        if(h[4] != h[5] || w[4] != w[5]){
            flag = false;
        }
        for(int i = 0; i<6;i++){
            set.add(h[i]);
            set.add(w[i]);
        }
        if(set.size() > 3){
            flag = false;
        }
        if(flag){
            System.out.println("POSSIBLE");
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
