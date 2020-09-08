package Autumn;

import java.util.*;

public class AL2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int m = in.nextInt();
        solution(n,m);
    }


    public static void solution(long n, int m){
          String str = String.valueOf(n);
          int len = str.length();
          int[] nums = new int[len];
          int index = 0;
          for(char c : str.toCharArray()){
              nums[index++] = c - '0';
          }
          if(len == 0){
              return;
          }
          Arrays.sort(nums);
          boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
          System.out.println(backtrace(nums,len,0,used,path,m));
    }

    public static long backtrace(int[] nums, int len, int depth, boolean[] used,Deque<Integer> path, int m){
        if(depth == len){
            ArrayList<Integer> integers = new ArrayList<>(path);
            if(integers.get(0) == 0){
                return 0;
            }
            long sum = 0;
            int size = integers.size();
            for(int i = 0; i<size ; i++){
                sum += Math.pow(10,(size-i-1))*integers.get(i);
            }
            if(sum % m ==0){
                return 1;
            }

        }
        int count = 0;
        for(int i = 0; i<len ; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            count += backtrace(nums,len,depth+1,used,path,m);
            used[i] = false;
            path.removeLast();
        }
        return count;
    }

    public static void swap(char[] chars , int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     *  public static void main(String[] args) {
     *         Scanner in = new Scanner(System.in);
     *         long n = in.nextLong();
     *         int m = in.nextInt();
     *         solution(n,m);
     *     }
     *
     *
     *     public static void solution(long n, int m){
     *         ArrayList<String> res = new ArrayList<>();
     *           String str = String.valueOf(n);
     *           backtrace(str.toCharArray(), 0, res,m);
     *           System.out.println(res.size());
     *     }
     *
     *     public static void backtrace(char[] chars, int i,
     *     ArrayList<String> res,int m){
     *         if(i == chars.length-1){
     *             String val = String.valueOf(chars);
     *             if(!res.contains(val)){
     *                 Integer num = Integer.valueOf(val);
     *                 if(num % m == 0 && val.charAt(0) != 0 ){
     *                     res.add(val);
     *                 }
     *             }
     *         }else{
     *             for(int j = i ; j<chars.length ; j++){
     *                 swap(chars,i,j);
     *                 backtrace(chars,i+1,res,m);
     *                 swap(chars,i,j);
     *             }
     *         }
     *     }
     *
     *     public static void swap(char[] chars , int i, int j){
     *         char temp = chars[i];
     *         chars[i] = chars[j];
     *         chars[j] = temp;
     *     }
     */

}
