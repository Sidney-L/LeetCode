class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(!cur.containsKey(word.charAt(i))){
                cur.put(word.charAt(i), new TrieNode());
            }
            cur = cur.get(word.charAt(i));
        }
        cur.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int k, TrieNode root){
        if(k == word.length())
            return root.isEnd();
        if(word.charAt(k)!= '.'){
            return root.containsKey(word.charAt(k))&&dfs(word,k+1,root.get(word.charAt(k)));
        }
        else{
            for(int i = 0; i < 26; i++){
                if(root.containsKey((char)('a'+i)))
                    if(dfs(word, k+1, root.get((char)('a'+i))))
                        return true;
            }
            return false;
        }
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
