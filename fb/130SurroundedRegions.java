class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    int n;
    int m;
    public void solve(char[][] board) {
        
        if(board.length == 0 || board[0].length == 0)
            return;
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < m; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[n-1][i] == 'O'){
                dfs(board, n-1, i);
            }
        }
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board, i, m-1);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int r, int c){
        if(board[r][c] != 'O')
            return;
        board[r][c] = 'E';
        for(int i = 0; i < 4; i++){
            int x = r + dx[i];
            int y = c + dy[i];
            if(x>=0 && x < n && y >= 0 && y < m){
                dfs(board, x, y);
            }
        }
    }
}
