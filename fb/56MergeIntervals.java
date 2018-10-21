/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new LinkedList<Interval>();
        Interval[] copy = intervals.toArray(new Interval[0]);
        Arrays.sort(copy, new IntervalOrder());
        if(intervals == null || intervals.isEmpty())
            return intervals;
        Interval cur = copy[0];
        for(int i = 0; i < copy.length; i++) {
            if(copy[i].start > cur.end) {
                ans.add(cur);
                cur = copy[i];
            }
            else if(cur.end < copy[i].end)
                cur.end = copy[i].end;
        }
        ans.add(cur);
        return ans;
    }
}
class IntervalOrder implements Comparator<Interval>{
    
    @Override
    public int compare(Interval o1, Interval o2) {
        if(o1.start != o2.start)
            return o1.start - o2.start;
        else
            return o1.end  - o2.end;
    }
}
