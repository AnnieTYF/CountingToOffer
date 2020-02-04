import java.util.HashMap;
import java.util.Map;

public class CountKInArray {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */

    /**
     * 解法一：利用hashmap统计，其实这里。。。可以直接遍历的，但是很显然，这很low
     * 16ms
     * @param array
     * @param k
     * @return
     */
  public static int GetNumberOfK(int [] array , int k) {
    if (array == null) {
        return 0;
    }
      HashMap<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        if (map.containsKey(array[i])) {
            count = map.get(array[i]);
            map.put(array[i], ++count);
        } else {
            map.put(array[i], 1);
        }
    }
    return map.containsKey(k) ? map.get(k) : 0;
  }


    /**
     * 解法二：解题思路，看到有序数组，就想到二分查找
     * 这道题就是二分查找第一个和最后一个，最后的数量等于最后一个的位置-第一个的位置
     * O(logn)
     * 13ms
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK2(int[] array,int k){
        if(array==null||array.length==0)
            return 0;
        int first=getFirstK(array,k,0,array.length-1);
        int last=getLastK(array,k,0,array.length-1);
        if(first==-1 ||last==-1){
            return 0;
        }
        else{
            return last-first+1;
        }

    }

    public static int getFirstK(int[] array,int k,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(k<array[mid])
                end=mid-1;
            else if(k>array[mid])
                start=mid+1;
            else{
                //这里是关键，如果k=array[mid],就将mid-1，直到找到第一个k=array[kFirst]
                if((mid>0&&array[mid-1]!=k)||mid==0)
                    return mid;
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    public static int getLastK(int[] array,int k ,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(k<array[mid])
                end=mid-1;
            else if(k>array[mid])
                start=mid+1;
            else{
               //这里是关键，如果k=array[mid],就将mid+1，直到找到最后一个k=array[kLast]
                if((mid<array.length-1&&array[mid+1]!=k)||mid==array.length-1)
                    return mid;
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }

    /**
     * 解法三：二分查找的改进
     * 因为data中都是整数，所以可以稍微变一下，
     * 不是搜索k的两个位置，而是搜索(k-0.5)和(k+0.5)这两个数应该插入的位置，然后相减即可。
     * 18ms
     */
    public static int GetNumberOfK3(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }
    private static int biSearch(int [] array, double k){
        int low = 0, high = array.length - 1;
        while(low <= high){
            int mid = low + (high -low) / 2;
            if(array[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String args[]){
        int [] array = {1,2,3,3,3,3,5};
        System.out.println(GetNumberOfK3( array , 3));
    }
}
