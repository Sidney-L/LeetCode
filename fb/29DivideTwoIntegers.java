class Solution {
    public int divide(int dividend, int divisor) {
        long x = dividend;
        long y = divisor;
        long ans = 0;
        boolean flag;
        if(x>=0 && y >0 || x < 0 && y < 0)
            flag = true;
        else
            flag = false;
        x = Math.abs(x);
        y = Math.abs(y);
        while(x >= y){
            long temp = y;
            long count = 1;
            while(x >= temp+temp){
                count += count;
                temp += temp;
            }
            ans += count;
            x -= temp;
        }
        if(!flag)
            ans = -ans;
        if(ans < Integer.MIN_VALUE||ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int)ans;
    }
}
