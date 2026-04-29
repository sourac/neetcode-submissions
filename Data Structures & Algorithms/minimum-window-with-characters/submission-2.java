class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        Map<Character,Integer> needMap=new HashMap<>();
        for(char c:t.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> sMap=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            sMap.put(c,sMap.getOrDefault(c,0)+1);
            while(isValidWindow(sMap,needMap)){
                if((right-left+1)<minLen){
                    minLen=(right-left+1);
                    start=left;
                }
                char leftChar=s.charAt(left);
                sMap.put(leftChar,sMap.get(leftChar)-1);
                if(sMap.get(leftChar)==0){
                    sMap.remove(leftChar);
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }


    public boolean isValidWindow(Map<Character,Integer> sMap,Map<Character,Integer> needMap){
        for(char c:needMap.keySet()){
            if(sMap.getOrDefault(c,0)<needMap.get(c)){
                return false;
            }   
        }
        return true;
    }
}
