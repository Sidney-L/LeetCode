class Solution {
    private int[] rows, cols, squs;
    
    public void solveSudoku(char[][] board) {
        if(board == null)
            return;
        if(board.length != 9 || board[0].length != 9)
            return;
        rows = new int[9];
        cols = new int[9];
        squs = new int[9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                rows[i] |= (1 << num);
                cols[j] |= (1 << num);
                squs[(i / 3)* 3 + (j / 3)] |= (1 << num);
            }
        }
        
        dfs(0, 0, board);
        
    }
    
    private boolean dfs(int x, int y, char[][] board) {
        if(y == board.length) {
            x++;
            y = 0;
        }
        if(x == board.length)
            return true;
        if(board[x][y] == '.') {
            for(int i = 1; i < 10; i++) {
                
                if(((rows[x]&(1<<i)) == 0) && ((cols[y]&(1<<i))==0) && ((squs[(x/3)*3+y/3]&(1<<i))==0)) {
                    board[x][y] = ("" + i).charAt(0);
                    rows[x] |= (1 << i);
                    cols[y] |= (1 << i);
                    squs[(x/ 3)* 3 + (y / 3)] |= (1 << i);
                    if(dfs(x, y+1, board)) {
                        return true;
                    }
                    //System.out.println("here");
                    board[x][y] = '.';
                    rows[x] -= (1 << i);
                    cols[y] -= (1 << i);
                    squs[(x / 3)* 3 + (y / 3)] -= (1 << i);
                }
            }
        }
        else {
            if(dfs(x, y+1, board))
                return true;
        }
        return false;
    }
}
