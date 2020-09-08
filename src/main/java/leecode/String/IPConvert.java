package leecode.String;

public class IPConvert {

    public static void IPConvert(String str) {
        String[] arr = str.split("\\.");
        long n=Long.parseLong(arr[0]);
        for(int i=1;i<arr.length;i++){
            //讲n转化成二进制，并向左移动8位，后面补0
            //最后将得到的二进制数字转回对应类型的十进制
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }
        System.out.println(n);
    }

    private static void TentoIp(String p) {
        long temp=Long.parseLong(p);
        String ip=Long.toBinaryString(temp);   //返回long参数作为基数2的无符号整数的字符串表示形式
        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append(0); //补位
            }
            sb.append(ip);
        }else if(ip.length()==32){
            sb.append(ip);
        }
        for(int i=0;i<sb.length()-8;i=i+8){
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }

    public static void main(String[] args) {
        String str = "167969729";
        TentoIp(str);
    }
}
