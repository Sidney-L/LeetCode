public class Vector2D implements Iterator<Integer> {
    //int i, j;
    //List<List<Integer>> vec2d;
    Iterator<List<Integer>> itrs;
    Iterator<Integer> row;
    public Vector2D(List<List<Integer>> vec2d) {
        //this.vec2d =  vec2d;
        //i = 0;
        //j = 0;
        if(vec2d == null || vec2d.size() == 0) return;
        itrs = vec2d.iterator();
        row = itrs.next().iterator();
        getNextRow();
    }
    
    @Override
    public Integer next() {
        //return vec2d.get(i).get(j++);
        int next = row.next();
        getNextRow();
        return next;
    }
    
    @Override
    public boolean hasNext() {
        /*
         while(i < vec2d.size()){
         if(j < vec2d.get(i).size()){
         return true;
         }
         else{
         j = 0;
         i++;
         }
         }
         return false;
         */
        return row!=null && row.hasNext();
    }
    private void getNextRow(){//make sure the row is not empty
        while(!row.hasNext()&&itrs.hasNext())
            row = itrs.next().iterator();
    }
}


/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
