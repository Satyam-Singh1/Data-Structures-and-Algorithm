class Solution {
    private int expandAroundCenter(String s, int l, int r) {
        int n = s.length();
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 0;
        int st = 0, en = 0;
        for (int i = 0; i < n; i++) {

            int evenLen = expandAroundCenter(s, i, i);
            int oddLen = expandAroundCenter(s, i, i + 1);

            len = Math.max(evenLen, oddLen);
            if (len > en - st + 1) {
                st = i - (len - 1) / 2;
                en = i + len / 2;
            }

        }
        return s.substring(st, en + 1);

    }
}