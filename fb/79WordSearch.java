class Solution {
    int n, m, step;
    int[][] st;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        if(word == null || word.length() == 0)
            return true;
        n = board.length;
        m = board[0].length;
        st = new int[n][m];
        step = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++, step++) {
                if(dfs(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int x, int y, char[][] board, String word, int index) {
        if(word.charAt(index)!=board[x][y])
            return false;
        if(index + 1 == word.length())
            return true;
        st[x][y] = step;//choose this char and check next step
        for(int i = 0; i < 4; i++) {//
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && a < n && b >= 0 && b < m && st[a][b]!=step) {
                if(dfs(a, b, board, word, index + 1))
                    return true;
            }
        }
        st[x][y] = 0;
        return false;
    }
}
