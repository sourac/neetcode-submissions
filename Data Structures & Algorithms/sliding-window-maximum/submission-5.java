class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     int [] result=new int[nums.length-k+1];
     Deque<Integer> deque=new ArrayDeque<>();
     int index=0;

     for(int right=0;right<nums.length;right++){
        //step 1: if the window is invalid, remove from the front
        while(!deque.isEmpty() && deque.peekFirst()<=right-k){
            deque.pollFirst();
        }
        //step 2: if the last index element is smaller than the incoming index element,
        //keep on removing until the condition fails
        while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right]){
            deque.pollLast();
        }
        //step 3: insert the index into the Deque
        deque.offerLast(right);
        //step 4: if the window is formed, store the result
        if(right>=k-1){
            result[index++]=nums[deque.peekFirst()];
        }
     }
     return result;   
    }
}
