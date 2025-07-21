class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        
       
        for(int i = 0 ; i <n ; i++){
            if(i==0 || i==n-1){
                str.append(s.charAt(i));
                continue;
            }
            char ch = s.charAt(i);
            if(s.charAt(i-1)==ch && s.charAt(i+1)==ch){
                continue;
            }
            str.append(ch);
        }
      
        return str.toString();
    }
}