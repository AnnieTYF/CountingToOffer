public class MultiplyArray {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
     * B[i] = 除A[i]之外的A相乘
     */

    /**
     * 解法一：暴力破解
     * 17ms
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {

       int[] B = new int[A.length];
       for(int i = 0; i<B.length;i++){
           B[i] = 1;
           for(int j = 0; j<A.length;j++){
               if(i == j){
                   continue;
               }else{
                   B[i] = B[i] * A[j];
               }
           }
       }
    return B;
  }

    /**
     * 解法二：等价于求矩阵的上下三角
     * B[i]的值可以看作下图的矩阵中每行的乘积。
     * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
     * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
     * 16ms
     * @param A
     * @return
     */
    public static int[] multiply2(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0 ] = 1;
       if(length != 0){
           //上三角
           for(int i = 1; i<length;i++){
               B[i] = B[i-1] * A[i-1];
           }
           //下三角
           int temp = 1;
           for(int j = length-2; j>=0;j--){
               temp = temp * A[j+1];
               B[j] = B[j] * temp;
           }
       }
        return B;
    }
    public static void main(String args[]){
        int[] numbers = {1,2,3,4,5};
        int[] result = multiply2(numbers);
        for(int n = 0; n<result.length;n++) {
            System.out.println(result[n]);
        }
    }
}
