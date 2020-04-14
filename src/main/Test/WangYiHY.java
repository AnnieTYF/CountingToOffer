import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WangYiHY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            int len = sc.nextInt();
            int[][] area = new int[m][m];
            for(int j = 0; j<m ; j++){
                for(int k = 0; k<m ; k++){
                    int temp = sc.nextInt();
                    area[j][k] = temp;
                }
            }
            int x = sc.nextInt();
            int y = sc.nextInt();
            solution(area,len,m,x,y);
        }
    }

    /**
     * 刀砍的范围是一个圆
     */
    public static void solution(int[][] area , int len , int m, int x , int y){
        double[][] supply = new double[m*m][2];
        //记录补给数
        int supplyCount = 0;
        //遍历数组
        for(int i = 0; i<m;i++){
            for(int j = 0; j<m;j++){
                int p = area[i][j];
                if(p != 0){
                    int xMinus = (x-i)<0 ? (i-x):(x-i);
                    int yMinus = (y-j)<0 ? (j-y):(y-j);
                    double length = Math.sqrt( Math.pow(xMinus,2) + Math.pow(yMinus,2));
                    //长度
                    supply[supplyCount][0] = length;
                    supply[supplyCount][1] = p;
                    supplyCount++;
                }
            }
        }
        double[][] array = new double[supplyCount+1][2];
        //长度相同，补给大的在前面，长度不同，长度大的在后面
       for(int i = 0; i<= supplyCount ; i++){
           array[i][0] = supply[i][0];
           array[i][1] = supply[i][1];
          /* for(int j = i; j<=supplyCount;j++){
               if(supply[i][0] > supply[j][0]){
                   double temp1 = supply[i][0];
                   double temp2 = supply[i][1];
                   supply[i][0] = supply[j][0];
                   supply[i][1] = supply[j][1];
                   supply[j][0] = temp1;
                   supply[j][1] = temp2;
               }
           }*/
       }
        Arrays.sort(array, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] == o2[0]){
                    return (int)(o2[1] - o1[1]);
                }else{
                    return (int)(o1[0] - o2[0]);
                }
            }
        });

        //遍历补给
        for(int i = 0; i<= supplyCount;i++){
            if(len >= array[i][0]){
                len += array[i][1];
            }
        }
       System.out.println(len);
    }
}
