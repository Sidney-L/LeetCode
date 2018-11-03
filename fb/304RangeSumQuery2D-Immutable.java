class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0)
            return;
        int n = matrix.length;
        int m = matrix[0].length;
        sum = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum[i][j] = (i-1 >= 0?sum[i-1][j]:0) + matrix[i][j];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum[i][j] += (j-1 >= 0?sum[i][j-1]:0);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - (col1-1>=0?sum[row2][col1-1]:0) - (row1-1>=0?sum[row1-1][col2]:0) + (row1-1>=0&&col1-1>=0?sum[row1-1][col1-1]:0);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
