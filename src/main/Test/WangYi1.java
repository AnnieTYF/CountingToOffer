import java.util.Scanner;

public class WangYi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        if (n == 2) {
            System.out.print(nums[1] - nums[0]);
        } else {
            System.out.print(solution(nums));
        }
    }

    public static long solution(long[] nums){
        long d = nums[1] - nums[0];
        for(int i = 1 ; i<nums.length;i++){
            long num = nums[i] - nums[i-1];
            d = Math.min(num,d);
        }
        for(int i = 2 ; i < nums.length ; i++){
            long temp = nums[i] - nums[i-1];
            if(d == 0){
                    return -1;
            }else if(!(temp%d == 0)){
                return -1;
            }
        }
     return d;
    }

}
