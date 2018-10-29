class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.containsKey(word.charAt(i))){
                cur = cur.get(word.charAt(i));
            }
            else{
                cur.put(word.charAt(i), new TrieNode());
                cur = cur.get(word.charAt(i));
            }
        }
        cur.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int i = 0;
        for(; i < word.length(); i++){
            if(!cur.containsKey(word.charAt(i)))
                return false;
            else
                cur = cur.get(word.charAt(i));
        }
        if(!cur.isEnd()||i!=word.length())
            return false;
        else
            return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            if(!cur.containsKey(prefix.charAt(i)))
                return false;
            cur = cur.get(prefix.charAt(i));
        }
        return true;
    }
}
class TrieNode{
    private TrieNode[] links;
    
    private final int R = 26;
    
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
