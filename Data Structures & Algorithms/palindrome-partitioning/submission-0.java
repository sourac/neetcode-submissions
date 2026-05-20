class Solution {
List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String string, int start, List<String> path) {

        //base case

        if (start==string.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i < string.length(); i++) {
            String sub = string.substring(start, i + 1);
            if (isPalindrome(sub)) {

                // choose
                path.add(sub);
                // explore
                backtrack(string, i + 1, path);
                // undo
                path.remove(path.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
