class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(numRows == 0)
            return list;
        LinkedList<Integer> templ = new LinkedList();
        templ.add(1);
        list.add(templ);
        for(int i = 1; i < numRows; i++){
            LinkedList<Integer> temp = new LinkedList();
            temp.add(1);
            for(int j = 0; j < i-1; j++){
                temp.add(list.get(i-1).get(j)+list.get(i-1).get(j+1));
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }
}
