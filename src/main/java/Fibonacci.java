public class Fibonacci {

    /**
     * 解法一：递归调用
     * 时间复杂度太大，有大量的重复计算，会导致内存溢出
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        int num = 0;
            if(n==0){
                num = 0;
            }else if(n==1){
              num =   1;
            }else{
                num =  fibonacci(n-1) + fibonacci(n-2);
            }
        return num;
    }
    public static void main(String args[]){
        System.out.println(fibonacci2(10));
    }

    /**
     * 解法二：所有递归都可以被循环代替
     * 所以可以用迭代法,时间复杂度O(n),空间复杂度为O(1)
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        if(n==0){
            return 0;
        }else if(n==1 || n==2) {
            return 1;
        }
        int nMinus1 = 1;
        int cur = 0;
        int nMinus2 = 0;

        for(int i=2;i <= n;i++){
           cur = nMinus1 + nMinus2;
           nMinus2 = nMinus1;
           nMinus1 = cur;
        }
        return cur;
    }

}
