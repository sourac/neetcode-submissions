class Solution {
    List<String> result=new ArrayList<>();
        String[] map = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return result;
        backtrack(digits,0,new StringBuilder());
        return result;
    }

    public void backtrack(String digits,int index, StringBuilder path){
        if(index==digits.length()) {
            result.add(path.toString());
            return;
        }

        // this is used to get the letters from the digit  
        char digit =digits.charAt(index);
        String letters=map[digit-'0'];

        for(int i=0;i<letters.length();i++){
            char ch=letters.charAt(i);
            //choose
            path.append(ch);
            //explore
            backtrack(digits,index+1,path);
            //undo
            path.deleteCharAt(path.length()-1);
        }  

    }
}
