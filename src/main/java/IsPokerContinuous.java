public class IsPokerContinuous {

    /**
     * LL今买了一副扑克牌,发现里面有2个大王,2个小王(一副牌原本是54张^_^).
     * 他随机从中抽出了5张牌,“红心A,黑桃3,小王,大王,方片5”,,决定大\小 王可以看成任何数字,
     * 并且A看作1,J为11,Q为12,K为13。
     * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)
     * 要求使用这幅牌模拟上面的过程,如果牌能组成顺子就输出true，否则就输出false。
     * 为了方便起见,你可以认为大小王是0。
     *
     * 首先，这个题目很绕，所以总结出来有这么几个点
     * 1.里面有4张大小王，默认为0，在顺子中可以转化成任何书，例如【0，2，3，4，6】也是顺子，因为0当5用了
     * 2.顺子是抽5张牌
     * 3.牌的取值范围  0<=k<=13
     */

    /**
     * 解法一：
     * 解题思路：
     * max 记录 最大值；min 记录 最小值；min ,max 都不记0
     * 1. max - min <5（这个时这道题的核心）
     * 2. 除0外没有重复的数字(牌)
     * 3. 数组长度为5
     * 15ms
     * 这个方法特别巧在于，他用数组来记录是否有重复的牌
     * 之前有一道题，也是这个思路，判断数字出现个数
     * @param numbers
     * @return
     */
    public static boolean isContinuous(int [] numbers) {
        //要注意加判空
        if(numbers.length != 5) return false;
        int[]d = new int[14];
        /**
         *  d[0]是拿来防止大小王数量影响判断是否有其余对子的，但其实去掉也不影响
         *  因为总共4个0，后面代码中 d[numbers[i]]++;，所以如果刚开始设为-5的话
         *  哪怕有4个0，结果也是-1，if(d[numbers[i]]>1){就不满足这个条件，
         *  而这个条件是用来判断是否是重复牌的。
         *  但其实当为0时，continue会跳过后面的重复判断
         *  所以不加这个d[0] = -5其实也是可以的。
         */
       // d[0] = -5;
        int len = numbers.length;
        int max = -1; //取最小值，作为最大值的初始值
        int min = 14; //取最大值，作为最小值的初始值
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            //这个continue处理的特别好
            if(numbers[i] == 0){
                continue;
            }
            //判断是否有重复的牌
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }
        }
        if(max -min<5){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        int[] nums = {0,0,0,0,6};
        System.out.println(isContinuous(nums));
    }
}
