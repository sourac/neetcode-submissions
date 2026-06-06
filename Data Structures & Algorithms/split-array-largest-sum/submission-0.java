class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0;
        int right=0;
        int ans=0;
        for(int num : nums){
            left=Math.max(num,left);
            right+=num;
        }
        ans=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canSplit(nums,k,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public boolean canSplit(int [] nums, int k, int limit){
        int groups=1;
        int currentSum=0;
        for(int num: nums){
            if(currentSum+num>limit){
                groups++;
                currentSum=0;
            }
            currentSum+=num;
        }
        return groups<=k;
    }
}