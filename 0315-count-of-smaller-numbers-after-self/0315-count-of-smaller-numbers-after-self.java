class Solution {
    static int[] bit;

    public static int findQuery(int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= (i & (-i));
        }
        return res;
    }

    public static void update(int i, int val) {
        while (i <bit.length) {
            bit[i] += val;
            i += (i & (-i));
        }

    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int size = 2 * 10_004;
        int offset = 10_001;
        bit = new int[size];
        List<Integer> list = new ArrayList<>();
        for(int i =n-1 ; i>=0 ; i--){
            int shiftedVal = nums[i]+offset;
            list.add(findQuery(shiftedVal-1));
            update(shiftedVal , 1);

         }
         Collections.reverse(list);
         return list;

    }
}