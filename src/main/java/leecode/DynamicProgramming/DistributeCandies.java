package leecode.DynamicProgramming;

public class DistributeCandies {
    /**
     * 分糖果，暴力破解
     * 时间复杂度O（N）
     * https://leetcode-cn.com/problems/distribute-candies-to-people/solution/fen-tang-guo-ii-by-leetcode-solution/
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int currentNum = 1;
        int currentPeople = 0;
        while(candies >= 0 ){
            //可以用result[currentPeople% num_people] += Math.min（candies，currentNum）
            if(candies > currentNum){
                result[currentPeople% num_people] += currentNum;
                candies -= currentNum;
                currentPeople++;
                currentNum++;
            }else{
                result[currentPeople%num_people] += candies;
                return result;
            }
        }
        return result;
    }

    public static void main(String args[])
    {
        int candies = 7;
        int num_people =4;
        int[] result = distributeCandies(candies,  num_people);
        for(int i = 0; i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
