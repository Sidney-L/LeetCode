/* The read4 API is defined in the parent class Reader4.
 int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int count = 0;
    private char[] ibuf = new char[4];
    public int read(char[] buf, int n) {
        if(n <= count){
            for(int i = 0; i < n; i++){
                buf[i] = ibuf[i];
            }
            for(int i = 0; i<count - n; i++){
                ibuf[i] = ibuf[i+n];
            }
            count -= n;
            return n;
        }
        int b = count;
        int index = b;
        for(int i = 0; i < count; i++){
            buf[i] = ibuf[i];
        }
        count = 0;
        while(b < n){
            int r = read4(ibuf);
            int i = 0;
            for(; i < r && b < n; i++){
                buf[index+i] = ibuf[i];
                b++;
            }
            index += i;
            if(i < r){
                for(; count + i < r; count++){
                    ibuf[count] = ibuf[count+i];
                }
            }
            if(r < 4){
                break;
            }
        }
        //buf[b] = '\0';
        return b;
    }
}
