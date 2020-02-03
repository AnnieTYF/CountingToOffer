public class InversePairsInArray {

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 例：
     * input : 1,2,3,4,5,6,7,0
     * output : 7
     * (7,0),(6,0),(5,0),(4,0),(3,0),(2,0),(1,0)
     * @param array
     * @return
     */


    //统计逆序对的个数
   static int cnt;

    /**
     * 解题思路：归并排序，记录逆序个数
     * @param array
     * @return
     */
    public static int InversePairs2(int [] array) {
        if(array.length != 0){
            divide(array,0,array.length-1);
        }
        return cnt;
    }

    //归并排序的分治---分
    private static void divide(int[] arr,int start,int end){
        //递归的终止条件
        if(start >= end)
            return;
        //计算中间值，注意溢出
        int mid = start + (end - start)/2;
        //递归分
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        //治
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        //存一下变量
        int i=start,j=mid+1,k=0;
        //下面就开始两两进行比较，若前面的数大于后面的数，就构成逆序对
        //你可以这么想，两个有序数组合并
        while(i<=mid && j<=end){
            //若前面小于后面，直接存进去，并且移动前面数所在的数组的指针即可
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
                //a[i]>a[j]了，那么这一次，从a[i]开始到a[mid]必定都是大于这个a[j]的，因为此时分治的两边已经是各自有序了
                cnt = (cnt+mid-i+1)%1000000007;
            }
        }
        //各自还有剩余的没比完，直接赋值即可
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=end)
            temp[k++] = arr[j++];
        //覆盖原数组
        for (k = 0; k < temp.length; k++)
            arr[start + k] = temp[k];
    }
    public static void main(String args[]){
        int [] array = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs2( array));
    }
}
