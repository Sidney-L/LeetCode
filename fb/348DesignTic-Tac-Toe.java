class TicTacToe {
    
    //int[][] board;
    /** Initialize your data structure here. */
    /*
     public TicTacToe(int n) {
     board = new int[n][n];
     }
     */
    
    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    /*
     public int move(int row, int col, int player) {
     board[row][col] = player;
     boolean flag = true;
     for(int i = 0; i<board.length; i++){
     if(board[row][i] != player)
     flag = false;
     }
     if(flag)
     return player;
     flag = true;
     for(int i = 0; i<board.length; i++){
     if(board[i][col] != player)
     flag = false;
     }
     if(flag)
     return player;
     flag = true;
     if(row == col){
     for(int i = 0; i<board.length; i++){
     if(board[i][i] != player)
     flag = false;
     }
     if(flag)
     return player;
     }
     flag = true;
     if(row == board.length - col - 1){
     for(int i = 0; i<board.length; i++){
     if(board[i][board.length - i - 1] != player)
     flag = false;
     }
     if(flag)
     return player;
     }
     return 0;
     }
     */
    int[] rowC, colC;
    int diagonal;
    int antiDiagonal;
    public TicTacToe(int n) {
        rowC = new int[n];
        colC = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }
    
    public int move(int row, int col, int player) {
        int move = player==1?1:-1;
        rowC[row] += move;
        colC[col] += move;
        if(row == col)
            diagonal+= move;
        if(row == rowC.length-1-col)
            antiDiagonal += move;
        if(Math.abs(rowC[row])==rowC.length || Math.abs(colC[col])==rowC.length||Math.abs(diagonal)==rowC.length||Math.abs(antiDiagonal)==rowC.length)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
