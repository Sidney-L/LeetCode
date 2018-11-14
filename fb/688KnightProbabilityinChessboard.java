class Solution {
    int[] dx = {2, 2, 1,-1,-2, -2, 1,-1};
    int[] dy = {1,-1,-2, 2,1,-1, 2,-2};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        for(; K >0; K--){
            double[][] dp2 = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < 8; k++){
                        int newr = i+dx[k];
                        int newc = j+dy[k];
                        if(newr>=0&&newr<N&&newc>=0&&newc<N){
                            dp2[newr][newc] += dp[i][j]/8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0;
        for(double[] row: dp){
            for(double e: row)
                ans += e;
        }
        return ans;
    }
}
