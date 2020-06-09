package leecode.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设计一种算法，打印 N 皇后在 N × N
 * 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/eight-queens-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EightQueens {

    static List<List<String>> res = new ArrayList<>();
    //初始化棋盘
    public static List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i<n;i++){
            Arrays.fill(board[i],'.');
        }
        //从第一行开始回溯
        backtrace(board,0);
        return res;
    }

    /**
     * 回溯算法，N叉树的遍历
     * 结束条件：row >= board.length,row 超过 board 的最后一行
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     */
    public static void backtrace(char board[][], int row){
        //结束条件
        if(row == board.length){
            List<String> list  = new ArrayList<>();
            //将整个二维数组添加到list中
            for(int i = 0; i<board.length;i++){
                list.add(String.valueOf(board[i]));
            }
            //将其中的一种可能添加到结果集中
            res.add(list);
            return;
        }
        //N叉树的遍历
        for(int i = 0; i<board[0].length;i++){
            //做选择
            board[row][i] = 'Q';
            //判断此时是否满足N皇后条件，满足后回溯，不满足则剪枝
            if(isVaild(board,row,i)){
                backtrace(board,row+1);
            }
            //撤销选择
            board[row][i] = '.';
        }
    }
    //剪枝
    public static boolean isVaild(char board[][], int row,int column){
        //判断上方的列是否有皇后冲突
        for(int i = row-1; i>=0;i--){
            if(board[i][column] == 'Q'){
                return false;
            }
        }
        //判断左上方是否有皇后互相冲突
        for(int i = row-1,j = column-1; i>=0 && j >=0;i-- ,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //判断是否在右对角线上
        for(int i = row-1,j = column+1;i>=0 && j<board[0].length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        solveNQueens(4);
    }
}
