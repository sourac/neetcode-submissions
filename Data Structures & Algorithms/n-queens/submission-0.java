class Solution {
List<List<String>> result=new ArrayList<>();
    Set<Integer> cols=new HashSet<>();
    Set<Integer> diag=new HashSet<>();
    Set<Integer> antidiag=new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char [] [] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        backtrack(0,board,n);
        return result;
    }

    public void backtrack(int row, char [][] board, int n){
        //base case when row==n means one solution is find, add to the result list, but result is 
        //List<List<String>> and we have char [][] board, so we convert char [][] board to List<List<String>>
        if(row==n){
            result.add(construct(board));
            return;
        }

        for(int col=0;col<n;col++){
            int diagonal=row-col;
            int antidiagonal=row+col;
            if(cols.contains(col)|| diag.contains(diagonal) || antidiag.contains(antidiagonal)){
                continue;
            }

            //choose
            board[row][col]='Q';
            cols.add(col);
            diag.add(diagonal);
            antidiag.add(antidiagonal);

            //explore
            backtrack(row+1,board,n);

            //undo
            board[row][col]='.';
            cols.remove(col);
            diag.remove(diagonal);
            antidiag.remove(antidiagonal);
        }
    }

    private List<String> construct(char [][] board){
        List<String> temp=new ArrayList<>();
        for(char [] row: board){
            temp.add(new String(row));
        }
        return temp;
    }
}
