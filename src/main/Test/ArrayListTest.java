import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] array = data.split(",");

    }
    public static ArrayList<String> find(String str) {
        String[] nums = str.split(",");
        int length = nums.length;
        int[] answer = new int[length];
        boolean[] flag = new boolean[length];
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<length;i++){
            char[] ch = nums[i].toCharArray();
            if(isSeq(ch) || isBao(ch)) {
               list.add(ch.toString());
            }
        }
        if(list == null){
            System.out.print("");
        }else {
            for (String data : list) {
                System.out.print(data + ",");
            }
        }
      return list;
    }
    public static boolean isSeq(char[] ch){
        int start = 2;
        int end = 2;
        int count = 0;
        boolean seq = false;
        //判断是不是靓号
        while(end < ch.length){
            if (ch[end] - ch[start] == 1){
                count++;
            }
            end++;
            if(count >= 3){
                seq = true;
            }
        }
        return seq;
    }
    public static boolean isBao(char[] ch){
        int start = 2;
        int end = 2;
        int count = 0;
        boolean bao = false;
        //判断是不是靓号
        while(end < ch.length){
            if (ch[end] - ch[start] == 0){
                end ++;
                count++;
            }
            if(count >= 3){
                bao= true;
            }
        }
        return bao;
    }

}
