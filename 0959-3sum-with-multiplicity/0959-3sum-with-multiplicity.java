class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] count = new long[101];
        long MOD = 1_000_000_007;

        // Step 1: Count frequency of each number
        for (int num : arr) {
            count[num]++;
        }

        long ans = 0;

        // Step 2: Try all combinations (a, b, c) such that a <= b <= c and a + b + c == target
        for (int i = 0; i <= 100; i++) {
            if (count[i] == 0) continue;
            for (int j = i; j <= 100; j++) {
                if (count[j] == 0) continue;
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (k < j) continue;

                if (i == j && j == k) {
                    // All same: C(count[i], 3)
                    ans += (count[i] * (count[i] - 1) * (count[i] - 2)) / 6;
                } else if (i == j && j != k) {
                    // Two same: i == j != k
                    ans += ((count[i] * (count[i] - 1)) / 2) * count[k];
                } else if (i < j && j == k) {
                    // Two same: j == k != i
                    ans += count[i] * ((count[j] * (count[j] - 1)) / 2);
                } else if (i < j && j < k) {
                    // All different
                    ans += count[i] * count[j] * count[k];
                }
            }
        }

        return (int)(ans % MOD);
    }
}
