class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        Map<Character, Integer> T = new HashMap();
        Map<Character, Integer> window = new HashMap();
        int total = t.length();
        for(int i = 0; i < t.length(); i++){
            T.put(t.charAt(i), T.getOrDefault(t.charAt(i), 0) + 1);
            if(T.get(t.charAt(i)) > 1)
                total--;
        }
        //System.out.println(total+ " " + T.size() + "!");
        int satisfy = 0;
        for(int r = 0, l = 0; r < s.length(); r++){
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            //System.out.println(window.get(s.charAt(r))+" " + T.get(s.charAt(r)));
            if(window.getOrDefault(s.charAt(r), 0).intValue() == T.getOrDefault(s.charAt(r), 0).intValue()){
                satisfy++;
            }
            while(l <= r && window.getOrDefault(s.charAt(l), 0).intValue() > T.getOrDefault(s.charAt(l), 0).intValue()){
                window.put(s.charAt(l),window.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
            //System.out.println(satisfy+" "+total);
            if(satisfy >= total && (res.equals("")||res.length() > r-l+1)){
                //System.out.println("reach here");
                res = s.substring(l,r+1);
            }
        }
        return res;
    }
}
