class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int maxLen=0;
        for(int left=0;left<nums.length;left++){
            int zeroes=0;
            for(int right=left;right<nums.length;right++){
                if(nums[right]==0) zeroes++;
                if(zeroes>k) break;
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}