class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int s = 0;
        int e = n-1;
        int maxArea = 0;
        while(s<e){
            int st = height[s];
            int end = height[e];
            int minVal = 0;
            if(st<end){
                minVal= st;
                s++;
            }else{
                minVal = end;
                e--;
            }
            maxArea = Math.max(maxArea,minVal*(e-s+1));
        }
        return maxArea;
    }
}