class TwoSum {
    HashMap<Integer, Integer> set;
    /** Initialize your data structure here. */
    public TwoSum() {
        set = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        set.put(number, set.getOrDefault(number, 0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> setK = set.keySet();
        Iterator<Integer> ite = setK.iterator();
        while(ite.hasNext()){
            int temp = ite.next();
            if(set.containsKey(value-temp)){
                if(value - temp == temp){
                    if(set.get(temp)>=2)
                        return true;
                }
                else
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
