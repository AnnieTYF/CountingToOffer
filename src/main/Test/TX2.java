import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class TX2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int k = 0; k<t;k++){
            int n = in.nextInt();
            long[][] a = new long[n][2];
            long[][] b = new long[n][2];
            for(int i = 0; i< n;i++){
                long x = in.nextLong();
                long y = in.nextLong();
                a[i][0] = x;
                a[i][1] = y;
            }
            for(int j = 0; j< n;j++){
                long x = in.nextLong();
                long y = in.nextLong();
                b[j][0] = x;
                b[j][1] = y;
            }
            distance(a,b,n);
        }

    }
    public static void distance(long[][] a, long[][] b,int n){
        double res = (a[0][0]-b[0][0])*(a[0][0]-b[0][0]) + (a[0][1]-b[0][1])* (a[0][1]-b[0][1]) ;
        for(int i = 0; i<n ; i++){
            long x1 = a[i][0];
            long y1 = a[i][1];
            for(int j = 0 ;j < n ;j++){
                long x2 = b[j][0];
                long y2 = b[j][1];
                double dis = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
                res = Math.min(res,dis);
            }
        }
        DecimalFormat df = new DecimalFormat("#.000");
        if(res == 0){
            System.out.println("0.000");
        }else{
            System.out.println(df.format(Math.pow(res,1/2.0)));
        }

    }
    /*
    2
4
0 0
0 1
1 0
1 1
2 2
2 3
3 2
3 3
4
0 0
0 0
0 0
0 0
0 0
0 0
0 0
0 0
     */
}
