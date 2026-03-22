class Solution {
    public boolean isPowerOfTwo(int n) {
            // Agart koi number 2 ka power hai to usme bss ek 1(set bit)
            //hot hai, to hume bss ek set bit htana hai aur agar number
            // 0 hojata hai to power of two
            // non-zero not power

            return n>0 &&(n&(n-1))==0;

           // --> n&n-1 --> removes the rightmost set bit
    }
}