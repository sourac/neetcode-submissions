class Solution {
public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char [][]board, String word, int row, int col, int index){
    if(index==word.length())return true;

    //invalid cases
    if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=word.charAt(index)) return false;

    //store the original value
    char temp=board[row][col];
    //mark the cell as visited
    board[row][col]='#';


        //explore
        boolean found=
        //searching down
        dfs(board, word, row+1, col, index+1) 

        ||

        //searchig to the right
        dfs(board, word, row, col+1, index+1)

        ||

        //searching up
        dfs(board, word, row-1, col, index+1)

        ||

        //searching to the left
        dfs(board, word, row, col-1, index+1);

        //undo
        board[row][col]=temp;

        return found;

    }

}
