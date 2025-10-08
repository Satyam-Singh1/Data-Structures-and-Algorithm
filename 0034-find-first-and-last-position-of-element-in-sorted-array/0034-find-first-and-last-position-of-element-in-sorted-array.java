class Solution {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;
        int first = -1;
        int last = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target && (mid == 0 || arr[mid - 1] != arr[mid])) {
                first = mid;
                break;
            } else if (arr[mid] >= target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] == target && (mid == n - 1 || arr[mid + 1] != arr[mid])) {
                last = mid;
                break;
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { first, last };
    }
}