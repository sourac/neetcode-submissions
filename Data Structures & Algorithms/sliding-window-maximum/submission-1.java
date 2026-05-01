class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 1. Remove out-of-window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            // 2. Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // 3. Add current index
            dq.offerLast(i);
            // 4. Record answer
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }   
        return result;
    }
}
