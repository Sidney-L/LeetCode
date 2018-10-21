class Solution {
    /* public double myPow(double x, int n) {
     double base = 0;
     int power = 0;
     if (n < 0){
     base = 1/x;
     power = -n;
     }
     else{
     base = x;
     power = n;
     }
     if(power == 1)
     return base;
     return myPow(base, Math.floor(power/2)) * myPow(base, Math.ceil(power/2));
     }
     */
    /*public double myPow(double x, int n) {
     double base = 0;
     int power = 0;
     if (n < 0){
     base = 1/x;
     power = -n;
     }
     else{
     base = x;
     power = n;
     }
     if(power == 1)
     return base;
     return myPow(base, (int)Math.floor(power/2.0)) * myPow(base, (int)Math.ceil(power/2.0));
     }
     */
    public double myPow(double x, int n) {
        long power = 0;
        double p = x;
        double ans = 1;
        if (n < 0)
            power = -(long)n;
        else
            power = (long)n;
        for(; power > 0; power >>= 1) {
            if((power & 1)==1) {
                ans *= p;
            }
            p *= p;
        }
        if(n >= 0)
            return ans;
        else
            return 1/ans;
    }
}
