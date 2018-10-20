class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            else if(st.size() == 0){
                return false;
            }
            else{
                if(map.get(s.charAt(i)) != st.pop())
                    return false;
                else{}
            }
        }
        if(st.size()!=0)
            return false;
        else
            return true;
    }
}
