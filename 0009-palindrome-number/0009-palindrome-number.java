class Solution {
    public boolean isPalindrome(int x) {
        long rev =0;
         long y = x;
       
        while(x>0){
            int curr = x%10;
            rev = rev*10 + curr;
            x = x/10;
        }
       
        return y==rev;
    }
}