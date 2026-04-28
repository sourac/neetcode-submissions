class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character,Integer> tmap=new HashMap<>();
        for(char c: t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        String result="";
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> smap=new HashMap<>();
            for(int j=i;j<s.length();j++){
                char c=s.charAt(j);
                smap.put(c,smap.getOrDefault(c,0)+1);
                if(isValidWindow(smap,tmap)){
                    if((j-i+1)<minLen){
                        minLen=(j-i+1);
                        result=s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
    }

    public boolean isValidWindow(Map<Character,Integer> smap, Map<Character,Integer> tmap){
        for(char c:tmap.keySet()){
            if(smap.getOrDefault(c,0)<tmap.get(c)){
                return false;
            }
        }
        return true;
    }
}
