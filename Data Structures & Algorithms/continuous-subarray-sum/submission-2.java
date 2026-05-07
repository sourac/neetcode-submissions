class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
     Map<Integer,Integer> map=new HashMap<>();
     map.put(0,-1);

     int prefixSum=0;
     for(int i=0;i<nums.length;i++){
        prefixSum+=nums[i];
        int remainder=prefixSum%k;
        if(remainder<0){
            remainder+=k;
        }

        if(map.containsKey(remainder)){
            int prevIndex=map.get(remainder);
            if(i-prevIndex>=2){
                return true;
            }
        }else{
        map.put(remainder,i);
        }
     }
     return false;   
    }
}