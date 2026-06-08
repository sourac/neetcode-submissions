class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0,k=0;

        int [] sol=new int[m+n];

        while(i<m & j<n){
            if(nums1[i]<nums2[j]){
                sol[k]=nums1[i];
                i++;
                k++;
            }else{
                sol[k]=nums2[j];
                k++;
                j++;
            }
        }

        while(i<m){
            sol[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n){
            sol[k]=nums2[j];
            k++;
            j++;
        }

        int total=n+m;
        if(total%2==0){
            return (sol[total/2-1]+sol[total/2])/2.0;
        }else{
            return (sol[total/2]);
        }
    }
}
