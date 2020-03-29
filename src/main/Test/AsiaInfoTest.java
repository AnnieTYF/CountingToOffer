public class AsiaInfoTest {
    /**
     * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
     * 这是一个斐波那契数列
     * n的分母 = n-2的分母+n-1的分母 = n-1的分子+n-1的分母
     * n的分子 = n-1的分母
     */

    public static void main(String[] args){
        int sum=0;
        for(int i=0;i<20;i++){
            int top= getTop(i+1);
            int bottom=getBottom(i+1);
            sum+=top/bottom;//每一项的值
        }
        System.out.println(sum);
    }

    //获取分子核心递归方法
    public static int getTop(int position){
        if(position==1){
            return 2;
        }
        if(position==2){
            return  3;
        }
        return getTop(position-1)+getTop(position-2);
    }

    //获取分母核心递归方法
    public static int getBottom(int position){
        if(position==1){
            return  1;
        }
        if(position==2){
            return 2;
        }
        return getBottom(position-1)+getBottom(position-2);
    }

}
