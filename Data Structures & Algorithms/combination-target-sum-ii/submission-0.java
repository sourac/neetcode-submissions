class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>());
        return result;
    }


    public void backtrack(int start,int [] nums, int remain, List<Integer> path){
        if(remain==0) result.add(new ArrayList<>(path));
        if(remain<0) return;

        for (int i = start; i < nums.length; i++) {
            if(i>start && nums[i]==nums[i-1]) continue;

            //choose
            path.add(nums[i]);
            //explore
            backtrack(i+1, nums, remain-nums[i], path);
            //undo
            path.remove(path.size()-1);
        }
    }
}
