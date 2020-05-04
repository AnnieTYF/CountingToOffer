import java.util.Scanner;

public class ACM1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[2*n];
        for(int i = 0; i<2*n;i++){
            int num = in.nextInt();
            data[i] = num;
        }
        solution(data);
    }
    public static void solution(int[] data){
        int count = 0;
        for(int i = 0; i<data.length ; i+=2){
            int k = data[i];
            if(data[i+1] == (k^1)){
               continue;
            }
            count++;
           for(int j = i+1; j<data.length;j++){
              if(data[j] == (k^1)){
                  int temp = data[i+1];
                  data[i+1] = data[j];
                  data[j] = temp;
                  break;
              }
           }
        }
        System.out.println(count);
    }
}
