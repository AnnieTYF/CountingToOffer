import java.util.ArrayList;
import java.util.Scanner;

public class QiAnXin2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] data = str.split(",");
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<data.length;i++){
            array.add(Integer.parseInt(data[i]));
        }
        solution(array);

    }
    public static void solution(ArrayList<Integer> array){
        int s1 = array.get(0) + array.get(1) + array.get(2) + array.get(3);
        int s2 = array.get(3) + array.get(4) + array.get(5) + array.get(6);
        int s3 = array.get(6) + array.get(7) + array.get(8) + array.get(0);
        if(s1 == s2 && s2 == s3){
            System.out.print("yes");
        }else{
            System.out.print("no");
        }
    }
}
