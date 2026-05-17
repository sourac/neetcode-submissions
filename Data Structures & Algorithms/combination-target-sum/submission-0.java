class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0,target,nums,new ArrayList<>());
        return result;
    }

    public void backtrack(int start, int remain, int [] nums, List<Integer> path){
        if(remain==0) result.add(new ArrayList<>(path));
        if(remain<0) return;

        for(int i=start;i<nums.length;i++){
            //choose
            path.add(nums[i]);
            //explore
            backtrack(i,remain-nums[i],nums,path);
            //undo
            path.remove(path.size()-1);
        }
    }
}
