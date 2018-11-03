class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0;i < graph.length; i++){//initialize the color to be -1 for unvisited
            color[i] = -1;
        }
        Stack<Integer> st = new Stack<Integer>();//stack for dfs
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                color[i] = 1;
                st.push(i);
                while(!st.isEmpty()){
                    int top = st.pop();
                    for(int e: graph[top]){
                        if(color[e] == -1){//unvisited
                            if(color[top] == 1)
                                color[e] = 0;
                            else
                                color[e] = 1;
                            st.push(e);
                        }
                        else if(color[e] == color[top])
                            return false;
                    }
                }
            }
        }
        return true;
        
    }
}
