import java.util.*;

public class xieCheng1 {

    /**
     贪心算法，遍历所有的通话，如果开始的通话时间<= 第一个的结束时间，那么就+1
     **/
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<ArrayList<Integer>> array = new ArrayList<>();
        for(int i = 0; i<n ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            String input = in.next();
            String[] data = input.split(",");
            list.add(Integer.parseInt(data[0]));
            list.add(Integer.parseInt(data[1]));
            array.add(list);
        }

        System.out.println(calcMinStaff(array,n));

    }
    static int calcMinStaff(List<ArrayList<Integer>> array, int n) {
        //按照结束时间排序，求最大不重叠区间
        Collections.sort(array, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(!o1.get(1).equals(o2.get(1))){
                    return o1.get(1) - o2.get(1);
                }else{
                    return o1.get(0) - o2.get(0);
                }
            }
        });
       int res = 1;
       int pre = 0;
       for(int i = 1; i<array.size();i++){
           if(array.get(i).get(0) >= array.get(pre).get(1)){
               res++;
               pre = i;
           }

       }
        return array.size() - res+1;
    }

}
