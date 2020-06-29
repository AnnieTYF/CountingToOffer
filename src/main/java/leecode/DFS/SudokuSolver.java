package leecode.DFS;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
         backtrace(board,0,0);
    }

    public boolean backtrace(char[][] board, int row, int column){
        //如果该行已经满了，换下一行继续开始
        if(column == 9){
            return backtrace(board,row+1,0);
        }
        //结束条件，如果i和j走到了最后一个空格
        if(row == 9 ){
            // 找到一个可行解，触发 base case
            return true;
        }
        // 如果该位置是预设的数字，跳过
        if(board[row][column] != '.'){
            return backtrace(board,row,column+1);
        }

        //选择列表
        for(char ch = '1'; ch <= '9'; ch++){
            // 如果遇到不合法的数字，就跳过
            if(!isVaild(board,row,column,ch)){
                continue;
            }
            //做选择，让当前位置等于ch
            board[row][column] = ch;
            //继续穷举下一个,/如果找到一个可行解，立即结束
            if(backtrace(board,row,column+1)){
                return true;
            }
            //撤销选择
            board[row][column] = '.';

        }
        return false;
    }

    public boolean isVaild(char[][] board,int row, int column,char ch){
        for(int i = 0; i<9 ; i++){
            //判断同一列是否有重复的
            if(board[row][i] == ch){
                return false;
            }
            //判断同一行是否重复
            if(board[i][column] == ch){
                return false;
            }
            // 判断 3 x 3 方框是否存在重复
            if(board[(row/3)*3 + i/3][(column/3)*3 + i%3] == ch){
                return false;
            }
        }
        return true;
    }
}
