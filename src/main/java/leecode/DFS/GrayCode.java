package leecode.DFS;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 0; i<n ; i++){
            int head = 1<<i; //要加的数
            for(int j = res.size()-1; j>=0 ; j--){
                res.add(head + res.get(j));
            }
        }
        return res;
    }
  //公式法
    public List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        for(int binary = 0;binary < 1 << n; binary++){
            gray.add(binary ^ binary >> 1);
        }
        return gray;
    }

}
