package leecode.String;

public class Compress {
    public static int compress(char[] chars) {
        int len = chars.length;
        int start = 0;
        int write = 0;
        for(int end = 0; end < len ; end++){
            if(end + 1 == len && chars[end] != chars[end+1]){
                chars[write++] = chars[start];
                for(char c : String.valueOf(end-start+1).toCharArray()){
                    chars[write++] = c;
                }
                start = end+1;
            }
        }
        return write;
    }
    public  static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};
        compress(chars);
    }
}
