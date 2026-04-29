class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left=0;
        Map<Character,Integer> s1Map=new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Map.put(c, s1Map.getOrDefault(c, 0)+1);
        }
        Map<Character,Integer> s2Map=new HashMap<>();
        for (int right = 0; right < s2.length(); right++) {
               char c=s2.charAt(right);
               s2Map.put(c, s2Map.getOrDefault(c, 0)+1);
               if ((right-left+1)>s1.length()) {
                    char leftChar=s2.charAt(left);
                    s2Map.put(leftChar, s2Map.get(leftChar)-1);
                    if(s2Map.get(leftChar)==0) s2Map.remove(leftChar);
                    left++;
               }
               if (s1Map.equals(s2Map)) return true;
        }
        return false;
    }
}
