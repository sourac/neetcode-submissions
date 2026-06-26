/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
// 1. Use .size() for Lists instead of .length
    if (intervals == null || intervals.size() <= 1) {
        return true;
    }
    
    // 2. Sort the list using Collections.sort and referencing the Interval properties
    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    
    // 3. Loop through the list using .get() to access elements
    for (int i = 1; i < intervals.size(); i++) {
        Interval previous = intervals.get(i - 1);
        Interval current = intervals.get(i);
        
        // If the previous meeting ends after the current meeting starts, there is a conflict
        if (previous.end > current.start) {
            return false;
        }
    }
    
    return true;
    }
}
