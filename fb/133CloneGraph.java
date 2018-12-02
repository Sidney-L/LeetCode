/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<Integer, UndirectedGraphNode> map = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
         if(node == null)
         return node;
         HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
         Queue<UndirectedGraphNode> q = new LinkedList();
         q.offer(node);
         map.put(node, new UndirectedGraphNode(node.label));
         while(!q.isEmpty()){
         UndirectedGraphNode temp = q.poll();
         for(UndirectedGraphNode neighbor: temp.neighbors){
         if(!map.containsKey(neighbor)){
         map.put(neighbor, new UndirectedGraphNode(neighbor.label));
         q.offer(neighbor);
         }
         map.get(temp).neighbors.add(map.get(neighbor));
         }
         }
         return map.get(node);
         */
        return dfs(node, map);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode root, HashMap<Integer, UndirectedGraphNode> map){
        if(root==null)
            return null;
        if(map.containsKey(root.label))
            return map.get(root.label);
        UndirectedGraphNode rootClone = new UndirectedGraphNode(root.label);
        map.put(root.label, rootClone);
        for(UndirectedGraphNode neighbor: root.neighbors){
            rootClone.neighbors.add(dfs(neighbor, map));
        }
        return rootClone;
    }
}
