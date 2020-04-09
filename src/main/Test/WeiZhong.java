import java.util.*;

public class WeiZhong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = Integer.valueOf(num);
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        solution(strs);
    }
//博弈论
    public static void solution(String[] strs){
        int count = 0;
        while(count < strs.length){
            //判断回文
            String str = strs[count];
                HashMap<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    if (!map.containsKey(str.charAt(i))) {
                        map.put(str.charAt(i), 1);
                    } else {
                        int num = map.get(str.charAt(i));
                        map.put(str.charAt(i), ++num);
                    }
                }
                //如果大于2，个数都是偶数个，或者只有1个奇数个，则是回文
                int odd = 0;
                for(Map.Entry<Character, Integer> temp : map.entrySet()){
                    if(temp.getValue()%2 == 1){
                        odd++;
                    }
                }
                if(odd % 2 == 1){
                    System.out.println("Cassidy");
                }else{
                    System.out.println("Eleanore");
                }
            count++;
        }
    }

}
