class Solution {

    int count = 0;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diagonal = new HashSet<>();
    Set<Integer> antidiagonal = new HashSet<>();

    // https://leetcode.com/problems/n-queens-ii/
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, n);
        return count;
    }
    /*
    The problem is similar to NQueens only, here we just want the count of possibilities for n queens
    where the queen won't attack
    */

    private void backtrack(int row, char[][] board, int n) {
        if (row==n) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            int diag=row-col;
            int antidiag=row+col;

            if (cols.contains(col) || diagonal.contains(diag) || antidiagonal.contains(antidiag)) {
                continue;
            }

            //choose
            board[row][col]='Q';
            cols.add(col);
            diagonal.add(diag);
            antidiagonal.add(antidiag);

            //explore
            backtrack(row+1, board, n);

            //undo
            board[row][col]='.';
            cols.remove(col);
            diagonal.remove(diag);
            antidiagonal.remove(antidiag);

        }

    }
}