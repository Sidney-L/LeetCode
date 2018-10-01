class Solution {
    private LinkedList<Character>[] digit = new LinkedList[10];
    private LinkedList<String> lc;
    
    private void init(){
        char a = 'a';
        lc = new LinkedList<String>();
        for(int i = 0; i < 10; i++){
            digit[i] = new LinkedList<Character>();
        }
        for(int i = 2; i < 10; i++){
            for(int j = 0; j < 3; j++){
                digit[i].add(a++);
            }
            if(i==7||i==9)
                digit[i].add(a++);
        }
    }
    private void dfs(String digits, int n, String cur){
        if(n == digits.length()){
            lc.add(cur);
            return;
        }
        
        int cur_num = digits.charAt(n) - '0';
        for(Character s: digit[cur_num]){
            dfs(digits, n+1, cur+s);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            lc = new LinkedList<String>();
            return lc;
        }
        else{
            init();
            dfs(digits, 0, "");
            return lc;
        }
        
    }
}

