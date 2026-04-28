class Solution {
    public int characterReplacement(String s, int k) {
     int maxLen=0;
    for(int i=0;i<s.length();i++){
        Map<Character,Integer> map=new HashMap<>();
        for(int j=i;j<s.length();j++){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            int maxFreq=0;
            for(int val: map.values()){
                maxFreq=Math.max(maxFreq,val);
            }
            int windowSize=(j-i+1);
            if(windowSize-maxFreq<=k){
                maxLen=Math.max(maxLen,windowSize);
            }
        }
      }
     return maxLen;   
    }
}
