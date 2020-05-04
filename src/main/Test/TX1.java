import java.util.*;

public class TX1 {
    static ArrayList<Integer> queue = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i<t;i++){
            int q = in.nextInt();
            for(int j = 0; j<q;j++){
                String s = in.next();
                if(s.equals("PUSH")){
                   int num = in.nextInt();
                   push(num);
                }else if(s.equals("TOP")){
                   System.out.println(top());
                }else if(s.equals("POP")){
                   pop();
                }else if(s.equals("SIZE")){
                    System.out.println(size());
                }else if(s.equals("CLEAR")){
                    clear();
                }
            }
            queue.clear();
        }
    }
    public static void  push(int node){
        queue.add(node);
    }

    public static int top(){
        if(queue.size() == 0){
            return  -1;
        }else{
            return queue.get(0);
        }
    }

    public static void pop(){
        if(queue.size() == 0){
            System.out.println(-1);
        }else{
            queue.remove(0);
        }
    }
    public static int size(){
       return queue.size();
    }

    public static void  clear(){
        queue.clear();
    }
}
