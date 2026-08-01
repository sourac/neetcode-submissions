class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct=nums[0];
        int minProduct=nums[0];
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            int maxTemp=Math.max(num,Math.max(maxProduct*num,minProduct*num));
            int minTemp=Math.min(num,Math.min(maxProduct*num,minProduct*num));
            maxProduct=maxTemp;
            minProduct=minTemp;
            ans=Math.max(ans,maxTemp);
        }
    return ans;
    }
}
