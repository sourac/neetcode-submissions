class Solution {
     List<String> answer=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack("",0,0,n);
        return answer;
    }

    public void backtrack(String string, int open, int close, int n){
        if(string.length()==2*n) {
            answer.add(string);
            return;
        }

        if(open<n){
            backtrack(string+"(", open+1,close,n);
        }
        if(close<open){
            backtrack(string+")", open, close+1, n);
        }
    }
}
