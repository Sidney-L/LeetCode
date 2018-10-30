/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */
import static java.lang.Math.toIntExact;
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1;
        long r = n;
        while(l<r){
            long mid = (l + r) /2;
            if(isBadVersion(toIntExact(mid)))
                r = mid;
            else
                l = mid + 1;
        }
        return toIntExact(r);
    }
}
