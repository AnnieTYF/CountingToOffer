package leecode.Array;

import java.util.ArrayList;

interface MountainArray {
     public int get(int index);
     public int length();
 }

public class FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length()-1;
        while(left < right){
            int mid = left + (right-left)/2;
            //升序
            if(mountainArr.get(mid) < mountainArr.get(mid+1)) {
               left = mid + 1;
            }else{
                right = mid;
            }
        }
        //找到峰值
        int peek = left;
        //查找左侧
        int index = leftSearch(0, peek, target,mountainArr);
        if(index != -1){
            return index;
        }
        //查找峰值右侧
        return rightSearch(peek + 1, mountainArr.length() -1, target,mountainArr);
    }

    public int leftSearch(int left, int right, int target, MountainArray mountainArr){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target < mountainArr.get(mid)){
                right = mid-1; //目标值在mid的左侧，收缩右边界
            }else if(target == mountainArr.get(mid)){
                return mid;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
    public int rightSearch(int left, int right, int target, MountainArray mountainArr){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target < mountainArr.get(mid)){
                left = mid +1;
            }else if(target == mountainArr.get(mid)){
                return mid;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

}
