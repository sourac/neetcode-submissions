class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //this will make sure there is no duplicate triplets
        Set<List<Integer>> res=new HashSet<>();
        if (nums.length==0) {
            return new ArrayList<>(res);
        }

        //sorting help us work from left to right
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left=i+1;
            int right=nums.length-1;
            while (left<right) {
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0) {
                    res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                }else if (sum<0) {
                    left++;
                }else if (sum>0) {
                    right--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
