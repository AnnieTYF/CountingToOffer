import java.util.Scanner;
import java.util.Stack;

public class TX4 {
   static Stack<Integer> s1 = new Stack<>();
   static Stack<Integer> s2 = new Stack<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i<n;i++){
            String s = in.next();
            if(s.equals("add")){
                int num = in.nextInt();
                add(num);
            }else if(s.equals("poll")){
                 poll();
            }else if(s.equals("peek")){
                 System.out.println(peek());
            }
        }
    }

    public static void  add(int node){
        s1.push(node);
    }
    public static void poll(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        s2.pop();
    }
    public static int peek(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
}
