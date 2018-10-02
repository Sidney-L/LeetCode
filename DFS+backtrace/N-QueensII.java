class Solution {
    private int count = 0;
    private boolean[] rows;
    private boolean[] cols;
    private boolean[] diags;
    private boolean[] antiDiags;
    
    public int totalNQueens(int n) {
        if(n == 0)
            return 0;
        rows = new boolean[n];
        cols = new boolean[n];
        diags = new boolean[2*n - 1];
        antiDiags = new boolean[2*n -1];
        dfs(0, 0, 0,n);
        return count;
    }
    
    private void dfs(int x, int y, int queen, int n){
        if(y == n){
            x++;
            y = 0;
        }
        if(x == n){
            if(queen == n)
                count++;
            return;
        }
        dfs(x, y+1, queen, n);
        if(!rows[x] && !cols[y] && !diags[x+y] && !antiDiags[n-1-x+y]){
            rows[x] = true;
            cols[y] = true;
            diags[x+y] = true;
            antiDiags[n-1-x+y] = true;
            dfs(x, y+1, queen+1, n);
            rows[x] = false;
            cols[y] = false;
            diags[x+y] = false;
            antiDiags[n-1-x+y] = false;
        }
    }
}
