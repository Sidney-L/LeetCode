class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = (a & b) << 1;
        if(carry == 0)
            return xor;
        else
            return getSum(xor, carry);
    }
}
