package leecode.String;

public class MinAddToMakeValid {

    public int minAddToMakeValid(String S) {
        // res 记录插入次数
        int res = 0;
        // 记录左括号量
        int left = 0;
        //核心思路是以左括号为基准，通过维护对右括号的需求数left，来计算最小的插入次数
        for(int i = 0; i<S.length() ; i++){
            if(S.charAt(i) == '('){
                left++;
            }
            if(S.charAt(i) == ')'){
                if(left > 0){
                    left--;
                }else{
                    res++;
                }
            }
        }
        //返回插入次数+剩余的左括号
        return res+left;
    }
}
