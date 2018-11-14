class Solution {
    public String toGoatLatin(String S) {
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        String[] s = S.split(" ");
        for(int i = 0; i < s.length; i++){
            if(set.contains(s[i].toLowerCase().charAt(0)))
                s[i] = s[i]+"ma";
            else{
                char head = s[i].charAt(0);
                s[i] = s[i].substring(1, s[i].length())+head+"ma";
            }
            for(int j = 0; j < i+1; j++)
                s[i] = s[i]+"a";
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length; i++){
            sb.append(s[i]);
            if(i != s.length-1)
                sb.append(" ");
        }
        return sb.toString();
    }
}
