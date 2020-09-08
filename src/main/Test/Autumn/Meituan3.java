package Autumn;

import java.util.Scanner;

public class Meituan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String need = in.nextLine();
        String[] s = need.split("\\s+");
        int length = Integer.parseInt(s[0]);
        int[][] car = new int[Integer.parseInt(s[0])][2];
        for(int i = 0; i<length ; i++){
            String[] s1 = in.nextLine().split("\\s+");
            car[i][0] = Integer.parseInt(s1[0]);
            car[i][1] = Integer.parseInt(s1[1]);
        }
        System.out.println(getNum(car,Integer.parseInt(s[1]),Integer.parseInt(s[2]),0));
    }

    public static int getNum(int[][] car, int carNum1, int carNum2, int index){
        if(index >= car.length || carNum1+carNum2>car.length-index || ((carNum1 <= 0) && (carNum2 <= 0))){
            return 0;
        }
        if(carNum1 > 0 && carNum2 > 0){
            int max = Math.max(getNum(car,carNum1-1,carNum2,index+1)+car[index][0],
                   getNum(car,carNum1,carNum2-1,index+1)+car[index][1]);
            return Math.max(max,getNum(car,carNum1,carNum2,index+1));
        }else if(carNum1 == 0){
            return Math.max(getNum(car,carNum1,carNum2,index+1),
                    getNum(car,carNum1,carNum2-1,index+1)+car[index][1]);
        }else if(carNum2==0){
            return Math.max(getNum(car,carNum1,carNum2,index+1),
                    getNum(car,carNum1+1,carNum2,index+1)+car[index][0]);
        }else{
            return getNum(car,carNum1,carNum2,index+1);
        }
    }
}
