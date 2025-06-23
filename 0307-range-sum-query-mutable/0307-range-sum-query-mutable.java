class NumArray {
    int[] arr;
    int[] bit;

    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        bit = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            updateBIT(i, arr[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;
        updateBIT(index, diff);

    }

    private void updateBIT(int index, int val) {
        index++;
        while (index < bit.length) {
            bit[index] += val;
            index += (index & (-index));
        }
    }

    public int sumRange(int left, int right) {
        return rangeSum(right) - rangeSum(left - 1);
    }

    private int rangeSum(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= (i & (-i));
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */