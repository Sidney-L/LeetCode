/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> l;
    int count;
    public NestedIterator(List<NestedInteger> nestedList) {
        count = 0;
        l = new LinkedList<Integer>();
        dfs(nestedList);
    }
    private void dfs(List<NestedInteger> list){
        for(NestedInteger e: list){
            if(e.isInteger())
                l.add(e.getInteger());
            else
                dfs(e.getList());
        }
    }
    @Override
    public Integer next() {
        return l.get(count++);
    }
    
    @Override
    public boolean hasNext() {
        return count < l.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
