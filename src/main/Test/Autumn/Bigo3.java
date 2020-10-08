package Autumn;

import java.util.ArrayList;
import java.util.List;

public class Bigo3 {

    List<List<String>> mirror(List<List<String>> data){
        List<List<String>> first = new ArrayList<>();
        List<List<String>> res ;
        for(List<String> list : data){
            List<String> newList = new ArrayList<>(list);
            for(int i = list.size()-1; i>=0 ; i--){
                newList.add(list.get(i));
            }
            first.add(newList);
        }
        res = new ArrayList<>(first);
        for(int i = first.size()-1; i>=0; i--){
            res.add(first.get(i));
        }

        return res;
    }
}
