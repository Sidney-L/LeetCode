class Solution {
    /*
     int[] dx = {1,-1,0,0};
     int[] dy = {0,0,-1,1};
     public int countBattleships(char[][] board) {
     int count = 0;
     for(int i = 0; i < board.length; i++){
     for(int j = 0; j < board[0].length; j++){
     if(board[i][j] == 'X'){
     count++;
     dfs(board, i, j);
     }
     }
     }
     return count;
     }
     private void dfs(char[][] board, int x, int y){
     board[x][y] = 'x';
     for(int i = 0; i < dx.length; i++){
     if(x+dx[i] >= 0 && x+dx[i] < board.length &&
     y+dy[i] >= 0 && y+dy[i] < board[0].length && board[x+dx[i]][y+dy[i]] == 'X')
     dfs(board, x+dx[i], y+dy[i]);
     }
     }
     */
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    if(i-1 >= 0 && board[i-1][j] != 'X' && j-1 >= 0 && board[i][j-1] != 'X')
                        count++;
                    else if(i-1 < 0 && j-1 >= 0 && board[i][j-1] != 'X')
                        count++;
                    else if(j-1<0 && i-1 >= 0 && board[i-1][j] != 'X')
                        count++;
                    else if(i-1 < 0 && j-1 < 0)
                        count++;
                }
            }
        }
        return count;
    }
}
