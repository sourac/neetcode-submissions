class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0) return new int[0][0];
        //sort the intervals with start time
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));

        int [] current= intervals[0];

        List<int[]> result=new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (current[1]>=intervals[i][0]) {
                current[1]=Math.max(current[1], intervals[i][1]);
            }else{
                result.add(current);
                current=intervals[i];
            }
        }
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
