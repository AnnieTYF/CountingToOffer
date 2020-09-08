package leecode.Array;

import java.util.HashMap;
import java.util.Scanner;

public class Decimal {
    /**
     * 输入是一个分数a/b，b>a>0
     * 输出这个分数对应的小数形式
     * 循环小数用括号把循环节括起来
     *
     * 1/4 = 0.25
     * 1/3 = 0.(3)
     * 1/6 = 0.1(6)
     * 1/7 =0.(142857)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(solution(a,b));
    }

    /**
     * 这题本质是找规律
     * 以 1/7 为例
     * 被除数  商  余数
     * 10     1     3
     * 30     4     2
     * 20     2     6
     * 60     8     4
     * 40     5     5
     * 50     7     1
     * 10     1     3
     * 小数点后部分，记录余数和商值，余数再次出现，则对应的商值为循环开始，直到最终结束
     * 若没有相同余数，则为有限小数。不考虑无限不循环小数
     * 可以用 hashmap 记录每个余数的对应位置。结果在这个位置之前，插入括号
     */
    public static String solution(int a, int b){
        HashMap<Integer,Integer> pos = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int val = a/b; //整除部分
        int divided = a%b; //余数
        res.append(val);
        if(divided != 0){
            res.append(".");
        }
        while(divided != 0){
            int temp = (divided * 10)/b; //被除数
            //如果余数相同
            if(pos.containsKey(divided)){
                res.insert(pos.get(divided),"(");
                res.append(")");
                break;
            }else{
                res.append(temp);
                pos.put(divided,res.length()-1);
            }
            divided = (divided * 10) %b; //余数
        }
        return res.toString();
    }

}
