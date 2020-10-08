package Autumn;

public class bigo1 {
    //相乘最后转换成相加
    public static String solution(String str1, String str2){
        if(str1.equals("0") || str1.equals("0")){
            return "0";
        }
        String ans = "0";
        //逐位相乘,str2逐位与str1相乘
        for(int i = str2.length()-1;i>=0;i--){
            int carry = 0;//进位
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j<str2.length()-1-i;j++){
                temp.append(0);
            }
            int e2 = str2.charAt(i)-'0';
            for(int j = str1.length()-1;j>=0||carry!=0;j--){
                int e1 = j>=0 ?str1.charAt(j)-'0':0;
                int num = (e1*e2+carry)%10;
                temp.append(num);
                carry = (e1*e2+carry)/10;
            }
            ans = addStrings(ans,temp.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String s1, String s2){
        StringBuilder res = new StringBuilder();
        int carry = 0;//进位
        int i = s1.length()-1;
        int j = s2.length()-1;
        while(i >=0 || j>=0){
            int n1 = i>=0 ? s1.charAt(i)-'0':0;
            int n2 = j>=0?s2.charAt(j)-'0':0;
            int temp = (n1+n2+carry)%10;
            carry = temp/10;
            res.append(temp);
            i--;j--;
        }
        if(carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args){
        String s1 = "15";
        String s2 = "15";
        System.out.print(solution(s1,s2));
    }

}
