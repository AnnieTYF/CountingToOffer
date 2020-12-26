package leecode.String;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i = 0;
        int j = 0;

        while(i < len1 || j< len2){
            // 用v1,v2来计算每一个块中版本号的大小,若v2的长度大于v1，则后面v1补0
            int v1 = 0;
            int v2 = 0;
            // 若当前的字符不是分隔符，则计算
            while(i < len1 && version1.charAt(i) != '.'){
                v1 = v1 * 10 + version1.charAt(i)-'0';
                i++;
            }
            while(j < len2 && version2.charAt(j) != '.'){
                v2 = v2 * 10 + version2.charAt(j)-'0';
                j++;
            }
            // 判断当前块中的版本号是否一致
            if(v1 != v2){
                if(v1 > v2){
                    return 1;
                }
                return -1;
            }
            // 跳过分隔符
            i++;
            j++;
        }
        // 全部比较完了，没有不等的则返回0
        return 0;
    }
}

