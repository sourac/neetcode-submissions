class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] res=new int[n];
        int [] lp=new int[n];
        int [] rp=new int[n];

        lp[0]=nums[0];
        rp[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            lp[i]=lp[i-1]*nums[i];
        }

        for(int j=n-2;j>=0;j--){
            rp[j]=rp[j+1]*nums[j];
        }

        res[0]=rp[1];
        res[n-1]=lp[n-2];
        for(int i=1;i<=n-2;i++){
            res[i]=lp[i-1]*rp[i+1];
        }
        return res;
    }
}  
