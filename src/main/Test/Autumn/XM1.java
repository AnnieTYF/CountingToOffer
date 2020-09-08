package Autumn;

import java.util.*;

public class XM1 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(search(board,word));
    }

    public static boolean search(char[][] board, String word){
        if(word.equals("")){
            return false;
        }
        char[] words = word.toCharArray();
        for(int i = 0; i<board.length ; i++){
            for(int j = 0; j<board[0].length ; j++){
                if(judge(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean judge(char[][] board, char[] word, int i, int j, int index){
        if(i<0 || j<0 || i>= board.length || j>=board[0].length || board[i][j] != word[index]){
             return false;
        }
        if(index == word.length-1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        if(judge(board,word,i+1,j,index+1) ||
        judge(board,word,i-1,j,index+1) ||
        judge(board,word,i,j+1,index+1) ||
        judge(board,word,i,j-1,index+1)){
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
