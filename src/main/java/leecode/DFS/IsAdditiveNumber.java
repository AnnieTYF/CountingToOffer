package leecode.DFS;

public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return backtrace(num,0,0,0,0);
    }
    /**
     *
     * @param num 字符串
     * @param index 当前元素的下标
     * @param preSum 前两数之和
     * @param preNum 前面一个数
     * @param count 当前是第几个数
     * 这道题没有可恢复的原样，没有可撤销的路径
     * @return
     */
    public boolean backtrace(String num, int index, long preSum, long preNum , int count){
        //一个有效的累加序列必须至少包含 3 个数
        if(index > num.length()-1){
            return count > 2;
        }
        long value = 0;
        for(int i = index ; i < num.length() ; i++){
            // 除 0 以外，其他数字第一位不能为 0，剪枝
            if(i > index && num.charAt(index) == '0'){
                break;
            }
            value = value * 10 + num.charAt(i)-'0';
            //不满足条件跳过，for循环结束后返回false
            if(count >= 2 && value != preSum) {
                continue;
            }
            if(backtrace(num, i + 1,preNum + value ,value, count+1)){
                return true;
            }
        }
        return false;
    }
}
