class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder();
        str.append('a');
        while (str.length() < k) {
            int len = str.length();
            for (int i = 0; i < len && str.length() < k; i++) {
                char curr = str.charAt(i);
                if (curr == 'z')
                    str.append('a');
                else {
                    str.append((char) (curr + 1));
                }
            }
        }
        return str.charAt(k - 1);
    }
}