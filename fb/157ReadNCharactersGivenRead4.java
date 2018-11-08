/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] bb = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        while(n > 0){
            int nn =  read4(bb);
            if(n >= nn){
                if(nn == 0)
                    break;
                for(int i = 0; i < nn; i++)
                    buf[count++] = bb[i];
                n -= nn;
            }
            else{//n < nn
                for(int i = 0; i < n; i++){
                    buf[count++] = bb[i];
                }
                n -= nn;
            }
        }
        return count;
    }
}
