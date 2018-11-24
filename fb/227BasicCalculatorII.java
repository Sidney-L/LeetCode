class Solution {
    public int calculate(String s) {
        /*
         LinkedList<String> l = new LinkedList();
         for(int i = 0; i < s.length();){
         if(s.charAt(i) == ' '){
         i++;
         continue;
         }
         if(Character.isDigit(s.charAt(i))){//push an integer operand
         StringBuffer sb = new StringBuffer();
         while(i < s.length()&&(Character.isDigit(s.charAt(i))||s.charAt(i) == ' ')){
         if(Character.isDigit(s.charAt(i)))
         sb.append(s.charAt(i));
         i++;
         }
         l.addLast(sb.toString());
         continue;
         }
         if(s.charAt(i) == '+' || s.charAt(i) == '-'){//push a low level operator
         l.addLast(s.charAt(i)+"");
         i++;
         }
         else{// * or /
         char operator = s.charAt(i);
         i++;
         String firstOp = l.removeLast();
         StringBuffer sb = new StringBuffer();
         while(i < s.length()&&(Character.isDigit(s.charAt(i))||s.charAt(i) == ' ')){
         if(Character.isDigit(s.charAt(i)))
         sb.append(s.charAt(i));
         i++;
         }
         if(operator == '*'){
         l.addLast(String.valueOf(Integer.parseInt(firstOp) * Integer.parseInt(sb.toString())));
         }
         else{
         l.addLast((Integer.parseInt(firstOp) / Integer.parseInt(sb.toString()))+"");
         }
         }
         
         }
         int res = Integer.parseInt(l.get(0));
         for(int i = 1; i < l.size();i++){
         if(l.get(i).equals("+"))
         res += Integer.parseInt(l.get(++i));
         else
         res -= Integer.parseInt(l.get(++i));
         }
         return res;
         */
        Stack<Integer> st = new Stack();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i) - '0');
            }
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'||i == s.length()-1){
                if(sign=='+'){
                    st.push(num);
                }
                if(sign=='-'){
                    st.push(-num);
                }
                if(sign=='*'){
                    int op1 = st.pop();
                    st.push(op1*num);
                }
                if(sign=='/'){
                    int op1 = st.pop();
                    st.push(op1/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while(!st.isEmpty())
            res+=st.pop();
        return res;
    }
}
