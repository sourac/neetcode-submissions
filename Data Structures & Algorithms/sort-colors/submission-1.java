class Solution {
    public void sortColors(int[] nums) {
        /*
        The problem is similar to move zeroes, where we have to move zero at right and non zero to the left.
        which is done in place and it's 2 way partitioning
        while this sort color where we have 2 number we have to partition in 3 groups.
        */

        int low=0;
        int mid=0;
        int high=nums.length-1;
        while (mid<=high) {
            //case 1: when current element is 0
            if (nums[mid]==0) {
                swap(nums,low,mid);
                low++;
                mid++;
            }else if (nums[mid]==1) {
                mid++;
            }else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int low, int mid) {
        int temp=nums[low];
        nums[low]=nums[mid];
        nums[mid]=temp;
    }
}