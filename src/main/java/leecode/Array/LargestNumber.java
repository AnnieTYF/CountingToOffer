package leecode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        ArrayList<String> array = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< nums.length;i++){
            array.add(String.valueOf(nums[i]));
        }
        //比较器
        Collections.sort(array,(o1,o2)-> (o2 + o1).compareTo(o1 + o2));
        if (array.get(0).equals("0")) {
            return "0";
        }
        for(String num : array){
            str.append(num);
        }
        return new String(str);
    }
}
