package leecode.SortAndSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickwithWeight {
    //每个数组中的数可能被抽到的概率，假设原数组为[1:3]，则下标0的概率是1/4，下标1的概率是3/4
    //但是这里为了方便计算，存的是1和3
    List<Integer> list = new ArrayList<>();
    int total = 0; //总的概率区间 = 1+3 = 4

    //预处理，计算每个数组下标的概率
    public RandomPickwithWeight(int[] w) {
        for(int num : w){
             total += num;
             list.add(total); //顺序插入，顺序存放
        }
    }

    public int pickIndex() {
        Random random = new Random();
        //从(0,3]这里取随机数，(0,1]就代表下标0，[2，3]就代表下标1
        int target = random.nextInt(total);
        //二分查找，搜索target在哪个区间范围
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            }
        }
        return -1;//没有查找到
    }

}
