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
    public int minMeetingRooms(List<Interval> intervals) {
        // 1. Use .size() instead of .length for Lists
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        // 2. Use Collections.sort and access the .start property
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 3. Iterate using the 'Interval' type instead of 'int[]'
        for (Interval interval : intervals) {
            // If the room with the earliest end time is free, clear it out
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            
            // Add the current meeting's end time to the heap
            minHeap.offer(interval.end);
        }
        
        return minHeap.size();
    }
}
