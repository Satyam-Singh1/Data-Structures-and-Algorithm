import java.util.Arrays;

class Solution {
    public int findLucky(int[] arr) {
        int maxi = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[maxi + 1];

        // Count frequencies
        for (int x : arr) {
            freq[x]++;
        }

        // Find the largest lucky number
        int result = -1;
        for (int i = 1; i <= maxi; i++) {
            if (freq[i] == i) {
                result = i;
            }
        }

        return result;
    }
}
