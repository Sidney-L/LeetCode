class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> que = new LinkedList<String>();
        map.put(beginWord, 1);
        que.add(beginWord);
        while(que.size()!=0){
            String s = que.remove();
            if(s.equals(endWord))
                return map.get(s);
            for(int i = 0; i < wordList.size(); i++){
                if(check(s, wordList.get(i)) && !map.containsKey(wordList.get(i))){
                    map.put(wordList.get(i), map.get(s)+1);
                    que.add(wordList.get(i));
                }
            }
        }
        return 0;
    }
    private boolean check(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        return count == 1;
    }
}
