class Solution {
    public int numSquares(int n) {
        int dist[] = new int[n+1];
        for(int i = 0; i<n+1; i++)
            dist[i] = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList();
        dist[0] = 0;
        q.offer(0);
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i = 1; i*i + t <= n; i++){
                int j = i*i + t;
                if(j == n)
                    return dist[t] + 1;
                else{
                    if(dist[j] > dist[t]+1){//newly discovere j
                        dist[j] = dist[t] + 1;
                        q.offer(j);
                    }
                }
            }
        }
        return n;
    }
}
