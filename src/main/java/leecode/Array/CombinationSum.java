package leecode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> trace = new ArrayList<>();
        Arrays.sort(candidates); //剪枝的前提是有序
        backtrace(candidates,0,trace,target);
        return res;
    }

    public void backtrace(int[] candidates, int start, List<Integer> trace, int target){
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if(target == 0){
            res.add(new ArrayList<>(trace));
            return;
        }
        for(int i = start; i<candidates.length;i++){
            // 重点理解这里剪枝，前提是候选数组已经有序
            if(target - candidates[i] < 0){
                break;
            }
            trace.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            backtrace(candidates,i,trace,target-candidates[i]);
            trace.remove(trace.size()-1);
        }
    }

    public  static void main(String[] args){
        int[] candidates = {2,3,5};
        //combinationSum(candidates, 8);
    }
}
