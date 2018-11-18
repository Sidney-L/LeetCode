class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for(String s: emails){
            String[] localAndDomain = s.split("@");
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < localAndDomain[0].length(); i++){
                if(localAndDomain[0].charAt(i) == '+')
                    break;
                if(localAndDomain[0].charAt(i) != '.')
                    sb.append(localAndDomain[0].charAt(i));
            }
            sb.append("@"+localAndDomain[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
