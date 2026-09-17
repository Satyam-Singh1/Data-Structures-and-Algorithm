class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character>st = new Stack<>();
        int i = 0 ; 
        while(i<n){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                char top = st.pop();
                 if ((ch == '}' && top != '{') ||
                        (ch == ')' && top != '(') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
            i++;
        }
        return st.isEmpty();
    }
}