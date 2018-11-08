class Solution {
    public int islandPerimeter(int[][] grid) {
        int w = grid.length;
        int l = grid[0].length;
        int[][] dummy = new int[w+2][l+2];
        for(int j = 0; j < l+2; j++){
            dummy[0][j] = 0;
            dummy[w+1][j] = 0;
        }
        for(int i = 0; i < w+2; i++){
            dummy[i][0] = 0;
            dummy[i][l+1] = 0;
        }
        for(int i = 1; i <= w; i++){
            for(int j = 1; j <= l; j++){
                dummy[i][j] = grid[i-1][j-1];
            }
        }
        int count = 0;
        for(int i = 1; i <= w+1; i++){//left up diffrence
            for(int j = 1; j <= l+1; j++){
                if(dummy[i][j] != dummy[i-1][j])
                    count++;
                if(dummy[i][j] != dummy[i][j-1])
                    count++;
            }
        }
        return count;
    }
}
