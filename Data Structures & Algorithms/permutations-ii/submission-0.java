class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // sort the array before processing such that duplicates became adjacent
        Arrays.sort(nums);
        // create a boolean array to mark the element whether used or not
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>());
        return result; 
    }


    private void backtrack(int[] nums, boolean[] used, List<Integer> path) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //duplicate pruning
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]) {
                continue;
            }

            //if already used
            if(used[i]) continue;

            //choose
            used[i]=true;
            path.add(nums[i]);
            //explore
            backtrack(nums, used, path);
            //undo
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}