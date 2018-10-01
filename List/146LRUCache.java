class LRUCache {
    class Node{
        int val;
        int key;
        Node left;
        Node right;
        public Node(){
            val = 0;
            key = 0;
            left = null;
            right = null;
        }
    }
    private int n;
    private HashMap<Integer, Node> map;
    private Node fh;
    private Node ft;
    private Node sh;
    private Node st;
    
    public LRUCache(int capacity) {
        n = capacity;
        map = new HashMap<Integer, Node>();
        fh = new Node();
        ft = new Node();
        sh = new Node();
        st = new Node();
        fh.right = ft;
        ft.left = fh;
        sh.right = st;
        st.left = sh;
        
        for(int i = 0; i < n; i++){
            Node p = new Node();
            insert(fh, p);
        }
    }
    
    private void insert(Node position, Node p){
        p.right = position.right;
        position.right = p;
        p.left = position;
        p.right.left = p;
    }
    
    private void delete(Node p){
        p.right.left = p.left;
        p.left.right = p.right;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            delete(map.get(key));
            insert(sh, map.get(key));
            return (map.get(key)).val;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            (map.get(key)).val = value;
            delete(map.get(key));
            insert(sh, map.get(key));
        }
        else{
            if(n == 0){
                n++;
                Node p = st.left;
                map.remove(p.key);
                delete(p);
                insert(ft.left, p);
            }
            n--;
            Node p = fh.right;
            p.key = key;
            p.val = value;
            delete(p);
            insert(sh, p);
            map.put(key, p);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
