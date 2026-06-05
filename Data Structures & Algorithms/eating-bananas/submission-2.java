class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=0;
        int ans=0;
        for(int i : piles){
            maxSpeed=Math.max(maxSpeed,i);
        }
        ans=maxSpeed;
        while(minSpeed<=maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            if(canEat(piles,h,mid)){
                ans=mid;
                maxSpeed=mid-1;
            }else{
                minSpeed=mid+1;
            }
        }
        return ans;
    }

    public boolean canEat(int [] piles, int h, int mid){
        long totalHours=0;
        for(int pile: piles){
            totalHours+=(int)Math.ceil((double)pile/mid);
            if(totalHours>h) return false;
        }
        return totalHours<=h;
    }

}
