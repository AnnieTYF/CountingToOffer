package leecode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    //最长回文串
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }
        }

        int res = 0;
        int odd = 0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue() % 2 == 1){
                odd++;
            }
            res += e.getValue();
        }
        return odd == 0 ? res : res-odd +1;
    }
}
