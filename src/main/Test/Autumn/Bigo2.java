package Autumn;

public class Bigo2 {

    public static <C extends Comparable> void sort(C[] array){
        if(null == array){
            return;
        }
        quickSort( array,0,array.length-1);
    }

    public static <C extends Comparable> void quickSort(C[] arr, int left, int right){
        if(arr == null || left >= right || arr.length <= 1){
            return;
        }
        int mid = partition(arr,left,right);
        quickSort(arr,left,mid);
        quickSort(arr,mid+1,right);
    }

    public static <C extends Comparable> int partition(C[] arr, int left,int right){
        C temp = arr[left];
        while(left < right){
            while((temp.compareTo(arr[right])>=0) && left < right){
                --right;
            }
            if((temp.compareTo(arr[right])<0)&& left < right){
                arr[left] = arr[right];
                ++left;
            }
            while((temp.compareTo(arr[left]))<=0 && left<right){
                ++left;
            }
            if((temp.compareTo(arr[left])>0) && left<right){
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }
}
