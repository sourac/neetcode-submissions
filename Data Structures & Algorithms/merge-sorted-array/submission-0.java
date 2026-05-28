class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         /*
        Here we have to merge these two sorted array into nums1(i.e inplace)
        now when we have sorted array and we need to merge them in place 
        we have to use the two pointer merge from back technique to avoid overwriting
        */

        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i]>nums2[j]) {
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }

        while (j>=0) {
            nums1[k--]=nums2[j--];
        }
    }
}