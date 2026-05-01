class Solution {

    public void reverse(int idx, int k, char[] arr) {
        int st = idx;
        int e = Math.min(idx + k - 1, arr.length - 1);

        while (st < e) {
            char temp = arr[st];
            arr[st] = arr[e];
            arr[e] = temp;
            st++;
            e--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        int i = 0;
        while (i < arr.length) {
            reverse(i, k, arr);
            i += 2 * k;
        }

        return new String(arr);
    }
}