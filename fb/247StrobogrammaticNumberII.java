class Solution {
    public List<String> findStrobogrammatic(int n) {
        return  find(n, n);
    }
    private List<String> find(int n, int m){
        if(n == 0){
            List<String> l = new LinkedList<String>();
            l.add("");
            return l;
        }
        if(n == 1){
            List<String> l = new LinkedList<String>();
            l.add("1");
            l.add("0");
            l.add("8");
            return l;
        }
        List<String> l1;
        List<String> ans = new LinkedList<String>();
        l1 = find(n-2, m);
        for(String s:l1){
            ans.add("1" + s + "1");
            ans.add("8" + s + "8");
            ans.add("9" + s + "6");
            ans.add("6" + s + "9");
            if(n < m)
                ans.add("0" + s + "0");
        }
        return ans;
    }
}
