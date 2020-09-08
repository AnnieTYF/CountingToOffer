package leecode.String;

public class StrStr {
    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
     * (从0开始)。如果不存在，则返回  -1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        // 等于，适用于两者长度相等的情况下（包含都为 ”“）
        for (int i = 0; i <= hLen - nLen; i++){
            int j;
            for (j=0;j < nLen; j++){
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen){
                return i;
            }
        }
        return -1;
    }
}
