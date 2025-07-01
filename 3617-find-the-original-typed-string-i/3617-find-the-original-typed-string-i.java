class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans =1;
        int i = 0;
        while(i<n-1){
            char ch = word.charAt(i);
            if(ch==word.charAt(i+1)) ans++;
            i++;
        }
        return ans;
    }
}