class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        int ans=0;
        for(int weight:weights){
            left=Math.max(weight,left);
            right+=weight;
        }
        ans=right;

        while(left<=right){ 
            int mid=left+(right-left)/2;
            if(canShip(weights,days,mid)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    private boolean canShip(int [] weights,int days, int capacity){
        int usedDays=1;
        int currentLoad=0;
        for(int weight:weights){
            if(currentLoad+weight>capacity){
                usedDays++;
                currentLoad=0;
            }
            currentLoad+=weight;
        }
        return usedDays<=days;
    }
}