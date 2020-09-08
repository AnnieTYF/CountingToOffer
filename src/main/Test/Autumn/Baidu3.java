package Autumn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Baidu3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i<t; i++){
            int cows = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>(cows);
            int feature = sc.nextInt();
            int temp = feature;
            for(int j = 0; j<feature ; j++){
                int forCount = sc.nextInt();
                while(forCount-- != 0){
                    int s = sc.nextInt();
                    int e = sc.nextInt();
                    for(int k = s; k<=e ; k++){
                        Integer count = map.get(k);
                        if(count == null){
                            map.put(k,1);
                        }else{
                            map.put(k,count+1);
                        }
                    }
                }
            }
            TreeSet<Integer> treeSet = new TreeSet<>();
            for(Integer num : map.keySet()){
                Integer cou = map.get(num);
                if(cou == temp){
                    treeSet.add(num);
                }
            }
            System.out.println(treeSet.size());
            int count = 0;
            for(Integer integer : treeSet){
                System.out.print(integer);
                count++;
                if(count<treeSet.size()){
                    System.out.print(" ");
                }
            }

        }
    }
}
