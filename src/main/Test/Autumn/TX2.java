package Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TX2 {

    static List<List<Character>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int k = in.nextInt();
        solution(str,k);
    }

    public static void solution(String str,int k){
        List<Character> trace = new ArrayList<>();
        backtrace(str,0,trace,0,k);
        List<Character> list = res.get(k);
        String s = "";
        for(Character ch : list){
            s = s+ch;
        }
        System.out.println(s);
    }

    public static void backtrace(String str, int start, List<Character> trace, int count,int k){
        if(!res.contains(trace)){
            res.add(new ArrayList<Character>(trace));
        }
        if(count == k){
            return;
        }
        for(int i = start ; i<str.length();i++){
            trace.add(str.charAt(i));
            backtrace(str,i+1,trace,++count,k);
            trace.remove(trace.size()-1);
        }
    }
}
