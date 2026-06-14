class Solution {
    public int numDecodings(String s) {
      int n=s.length();
       int [] dp=new int[n+1];
       //base case: ways to decode empty string is 1
       dp[0]=1;
       for (int i = 1; i <=n; i++) {
        //choice 1: Single digit
         if(s.charAt(i-1)!='0'){
            dp[i]+=dp[i-1];
         }
         //choice 2: Double digit
         if (i>=2) {
            int num=(s.charAt(i-2)-'0')*10 +
                    (s.charAt(i-1)-'0');
            if(num>=10 && num <=26){
                dp[i]+=dp[i-2];
            }        
         }
       }    
       return dp[n];
    }
}
 