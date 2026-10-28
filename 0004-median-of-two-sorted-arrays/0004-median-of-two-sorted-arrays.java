class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int leftsize = (m + n + 1) / 2;
        int l1 = Integer.MIN_VALUE, r1 = Integer.MIN_VALUE;
        int l2 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
        int l = 0;
        int h = n;
        while (l <= h) {
            int mid = (l + h) / 2;
            int mid2 = leftsize - mid;
            l1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            r1 = mid == n ? Integer.MAX_VALUE : nums1[mid];

            l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            r2 = mid2 == m ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                return ((double) Math.max(l1, l2)
                        + Math.min(r1, r2)) / 2.0;

            } else if (l1 > r2) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}