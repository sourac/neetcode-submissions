class Solution {
    public int findKthLargest(int[] nums, int k) {
        //In java, PriorityQueue by default is minHeap(which keeps smallest at the top always)
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int num : nums) {
            //add the current element into the heap
            minHeap.offer(num); 

            if (minHeap.size()>k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
