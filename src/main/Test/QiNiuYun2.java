import java.util.ArrayList;
import java.util.Scanner;

public class QiNiuYun2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i<n;i++){
            String str = in.nextLine();
            arrayList.add(str);
        }
        for(String str : arrayList){
            solution(str);
        }
    }
    /*public static void solution(String str){
       while(true){
           StringBuilder res = new StringBuilder();
           for(int i = 0; i<str.length();i++){
               if(i != str.length()-1){
                   if(str.charAt(i) != str.charAt(i+1)){
                       res.append(str.charAt(i));
                   }else{
                       ++i;
                   }
               }else{
                   res.append(str.charAt(i));
               }
           }
           if(res.toString().equals(str)){
               break;
           }else{
               str = res.toString();
           }
       }
        if(str.length() == 0){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }*/
    public static void solution(String str){
        ArrayList<Character> array = new ArrayList<>();

        for(int i = 1 ; i<str.length();i++){
            if(array.contains(str.charAt(i)) && (array.get(array.size()-1) == str.charAt(i))){
                array.remove(array.size()-1);
            }else{
                array.add(str.charAt(i));
            }
        }
        if(array.size() != 0){
            System.out.println("No");
        }else{
           System.out.println("Yes");
        }
    }
}
