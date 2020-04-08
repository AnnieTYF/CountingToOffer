package leecode.String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 进阶：如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 这个意味着字符不止26位了，就不能再用数组，而要用hashmap，就是我第一开始的做法
 * 虽然可能效率没数组高，但是可以适应绝大部分情况
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons/275/string/1142/
 */
public class IsAnagram {
    //想法一：将其中一个字符串放入到hashset中，另一个字符串判断字符是否在里面
    //不过这个存在一个问题，可能是同字母数不同
    //所以可以换成hashmap，找到count-1，相当于一个计数器
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        char[] charCur = chs.length > cht.length ? cht:chs;
        char[] charCompare = chs.length > cht.length ? chs:cht;

        for(int i = 0; i<charCur .length;i++){
            if(!map.containsKey(charCur [i])){
                map.put(charCur [i],1);
            }else{
                int count = map.get(charCur [i]);
                map.put(charCur[i],++count);
            }
        }
        for(int j = 0; j<charCompare.length;j++){
            if(map.containsKey(charCompare[j]) && (map.get(charCompare[j]) > 0)){
                int count = map.get(charCompare[j]);
                map.put(charCompare[j],--count);
            }else{
                return false;
            }
        }
        return true;
    }
    /**
     * 想法一的优化
     * 我们可以不用hashmap实现hashmap的功能，比如说这种字符，就可以用数组优化
     * 这个都不用排序，时间复杂度O(N)
     * 2 ms
     */
    public boolean isAnagram22(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        //因为只有26个字符
        int[] count = new int[26];

        for(int i = 0; i<chs .length;i++){
           count[chs[i] - 'a']++;
        }
        for(int j = 0; j<cht.length;j++){
            count[cht[j]-'a']--;
            if(count[cht[j]-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：排序，5 ms
     * 时间复杂度：O(nlogn)
     * 因为，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlogn)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        int length = chs.length;
        for(int i = 0; i<length;i++){
            if(! (chs[i] == cht[i])){
                return false;
            }
        }
       return true;
    }

    /**
     * 方法二的代码优化，官方文档
     * 这样一改就避免了自己for循环比较，虽然底层原理一样
     * 3 ms
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram12(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        return Arrays.equals(chs,cht);
    }
}
