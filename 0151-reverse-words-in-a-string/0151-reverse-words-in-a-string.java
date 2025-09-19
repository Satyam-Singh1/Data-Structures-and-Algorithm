class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        String []words = str.split("\s+");
        StringBuilder res = new StringBuilder();
        int n = words.length;
        for(int i = n-1 ; i>=0 ; i--){
            res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    
    }
}