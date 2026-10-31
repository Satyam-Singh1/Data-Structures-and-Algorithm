class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int st = 0 ; 
        int en = n-1;
        int maxi = 0;
        while(st<en){
            int d = en-st;
            int h = Math.min(height[st],height[en]);
            maxi = Math.max(maxi , d*h);
            if(height[st]<height[en]){
                st++;
            }else{
                en--;
            }
        }
        return maxi;
    }
}