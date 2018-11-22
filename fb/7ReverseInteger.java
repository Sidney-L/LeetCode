class Solution {
    public int reverse(int x) {
        long temp = 0;
        while(x!=0){
            temp = (x%10) + temp * 10;
            x /= 10;
        }
        if(temp > (long)Integer.MAX_VALUE || temp < (long)Integer.MIN_VALUE)
            return 0;
        else
            return (int)temp;
    }
}
