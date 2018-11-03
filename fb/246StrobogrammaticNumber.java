class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        int boundary = num.length()%2==0?num.length()/2:num.length()/2+1;
        for(int i = 0, j = num.length()-1; i < boundary; i++,j--){
            if(!map.containsKey(num.charAt(i))||!map.containsKey(num.charAt(j)))
                return false;
            else if(map.get(num.charAt(i))!=num.charAt(j)||map.get(num.charAt(j))!=num.charAt(i))
                return false;
        }
        return true;
    }
}
