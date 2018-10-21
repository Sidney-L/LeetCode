class Solution {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    int hundred = 100;
    int thousand = 1000;
    int million = 1000000;
    int billion = 1000000000;
    public String numberToWords(int num) {
        String[] num20 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] num29 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        for(int i = 0; i < 20; i++) {
            map.put(i, num20[i]);
        }
        for(int i = 20; i < 100; i+=10) {
            map.put(i, num29[i/10-2]);
        }
        map.put(hundred, "Hundred");
        map.put(thousand, "Thousand");
        map.put(million, "Million");
        map.put(billion, "Billion");
        String ans = "";
        for(int i = billion; i >= 1000; i/=1000) {
            if(num >= i) {
                ans += " " + get3(num/i) + " " + map.get(i);
                num %= i;
            }
        }
        if(num!=0)
            ans += " " + get3(num);
        if(ans.isEmpty()) {
            ans += " " + map.get(0);
        }
        return ans.substring(1);
    }
    
    private String get3(int num) {
        String ans = "";
        if(num >= hundred) {
            ans += " " + map.get(num/hundred) + " " + map.get(hundred);
            num %= hundred;
        }
        if(num != 0) {
            if(num < 20)
                ans += " " + map.get(num);
            else if(num % 10 == 0)
                ans += " " + map.get(num);
            else
                ans += " " + map.get(num / 10 * 10) + " " + map.get(num % 10);
        }
        return ans.substring(1);
    }
}
