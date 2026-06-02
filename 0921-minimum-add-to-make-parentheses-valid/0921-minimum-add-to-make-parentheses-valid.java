class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                st.push(curr);
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    cnt++;
                }
            }
        }
        return cnt + st.size();
    }
}