class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>());
        return result;
    }
    
    public void backtrack(int start, int[] nums, List<Integer> path){
        //add current subset
        result.add(new ArrayList<>(path));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;

            //choose
            path.add(nums[i]);
            //explore
            backtrack(i+1,nums,path);
            //undo
            path.remove(path.size()-1);
        }
    }
}
