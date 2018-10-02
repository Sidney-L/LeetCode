class Solution {
    private int m;
    private int n;
    private char[][] map;
    public int numIslands(char[][] grid) {
        if(grid == null)
            return 0;
        if( grid.length == 0){
            return 0;
        }
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        for( int i = 0; i < m; i ++){
            for( int j = 0; j < n; j ++){
                if ( grid[i][j] == '1' ){
                    res ++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }
    public void dfs(int x, int y, char[][] grid) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        grid[x][y] = '0';
        for( int i = 0; i < 4; i ++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && a < m && b >= 0 && b < n && grid[a][b] == '1'){
                dfs(a, b, grid);
            }
        }
    }
}
