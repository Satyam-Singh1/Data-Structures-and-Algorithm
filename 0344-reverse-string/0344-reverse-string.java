class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int st = 0;
        int e = n-1;
        while(st<=e){
            char temp = s[st];
            s[st] = s[e];
            s[e]=temp;
            st++;
            e--;
        }
    }
}