class Solution {
    final int[] dx = {-1, 0, 1, 0};
    final int[] dy = {0, 1, 0, -1};
    final int EMPTY = Integer.MAX_VALUE;
    final int GATE = 0;
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<int[]>();
        if(rooms.length == 0)
            return;
        int n = rooms.length;
        int m = rooms[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rooms[i][j] == 0)
                    q.add(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i = 0; i < 4; i++){
                int row = temp[0] + dx[i];
                int col = temp[1] + dy[i];
                if(row >= n || row < 0 || col >= m || col < 0 || rooms[row][col] != EMPTY)
                    continue;
                else{
                    rooms[row][col] = rooms[temp[0]][temp[1]] + 1;
                    q.add(new int[]{row, col});
                }
            }
        }
    }
}
