class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> union = new HashMap();
        for(List<String> account: accounts){
            String name = "";
            for(String email: account){
                if(name == ""){
                    name = email;
                    continue;
                }
                union.computeIfAbsent(email, x->new ArrayList<String>()).add(account.get(1));
                if(email!=account.get(1))
                    union.computeIfAbsent(account.get(1), x->new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }
        Set<String> seen = new HashSet();
        List<List<String>> ans = new LinkedList();
        for(String email: union.keySet()){
            if(!seen.contains(email)){
                seen.add(email);
                Stack<String> st = new Stack();
                st.push(email);
                List<String> component = new LinkedList();
                while(!st.isEmpty()){
                    String node = st.pop();
                    component.add(node);
                    for(String neighbor: union.get(node)){
                        if(!seen.contains(neighbor)){
                            seen.add(neighbor);
                            st.push(neighbor);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
}
