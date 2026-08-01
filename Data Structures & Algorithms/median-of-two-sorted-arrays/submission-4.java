class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        if (n>m) return findMedianSortedArrays(b, a);
        int lo=0;
        int hi=n;
        while (lo<=hi) {
            int mid1=(lo+hi)/2;
            int mid2=(n+m+1)/2-mid1;

            //find element to the left and right of partition in a[]
            int l1=(mid1==0)? Integer.MIN_VALUE:a[mid1-1];
            int r1=(mid1==n)?Integer.MAX_VALUE:a[mid1];

            //find element to the left and right of partition in b[]
            int l2=(mid2==0)? Integer.MIN_VALUE:b[mid2-1];
            int r2=(mid2==m)?Integer.MAX_VALUE:b[mid2];

            //if it's a valid parition
            if (l1<=r2 && l2<=r1) {
                //if total elements are even, then median will be average of two middle element
                if ((n+m)%2==0) {
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
                }
                //if odd element then median is the middle element
                else
                    return Math.max(l1, l2);
            }

            if(l1>r2)
                hi=mid1-1;
            else
                lo=mid1+1;
        }
        return 0;
    }
}
