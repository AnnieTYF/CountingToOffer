package Autumn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaiDu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n ; i++){
            int num = sc.nextInt();
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                int count = map.get(num);
                map.put(num,++count);
            }
        }
        if(map.containsKey(0) && map.containsKey(5)){
            int nineCount = map.get(5);
            int zheng = nineCount/9;
            int zeroCount = map.get(0);
            if(zeroCount == 0 || zheng == 0){
                System.out.println(-1);
            }else{
                for(int i = 0; i<zheng*9 ; i++){
                    System.out.print(5);
                }
                for(int i = 0; i<zeroCount ; i++){
                    System.out.print(0);
                }
            }
        }else{
            System.out.println(-1);
        }
    }
}
