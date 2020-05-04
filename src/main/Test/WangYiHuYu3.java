import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WangYiHuYu3 {
    //求全排列乘以权重


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(judge( board, words,i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judge(char[][] board,char[] word,int i, int j,int index){

        //超过界限/不等于/之前走过了
        if(i<0 || j<0 || i>=board.length || j>=board[0].length  || board[i][j] != word[index] )
            return false;
        if(index == word.length-1){
            return true;
        }
        //标注之前走过的空格，防止回填,剪枝
        char tmp = board[i][j];
        board[i][j] = '/';
        if(judge(board,word,i+1,j,index+1) ||
                judge(board,word,i-1,j,index+1) ||
                judge(board,word,i,j-1,index+1) ||
                judge(board,word,i,j+1,index+1)){
            return true;
        }
        board[i][j] = tmp;
        return false;
    }

}
