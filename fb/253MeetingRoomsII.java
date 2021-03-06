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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        int[] endArray = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++)
            endArray[i] = intervals[i].end;
        Arrays.sort(endArray);
        Arrays.sort(intervals,new IntervalOrder());
        int minEnd = intervals[0].end;
        int count = 1;
        int pointer = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < minEnd){
                count++;
                minEnd = Math.min(minEnd, intervals[i].end);
            }
            else{
                minEnd = endArray[++pointer];
                continue;
            }
        }
        return count;
    }
    
}

class IntervalOrder implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        if(i1.start != i2.start)
            return i1.start - i2.start;
        else
            return i1.end-i2.end;
    }
}
