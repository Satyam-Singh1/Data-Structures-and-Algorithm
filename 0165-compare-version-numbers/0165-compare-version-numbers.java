class Solution {
    public int compareVersion(String version1, String version2) {
        String[] t1 = version1.split("\\.");
        // int []token1 = new int[2];
        // token1[0] = Integer.parseInt(t1[0]);
        // token1[1] = Integer.parseInt(t1[1].trim());
        String[] t2 = version2.split("\\.");
        // int []token2 = new int[2];
        // token2[0] = Integer.parseInt(t2[0]);
        // token2[1] = Integer.parseInt(t2[1].trim());

        int i = 0, j = 0;
        while (i < t1.length || j < t2.length) {
            int v1 = 0;
            if (i < t1.length) {
                v1 = Integer.parseInt(t1[i]);
                i++;
            }
            int v2 = 0;
            if (j < t2.length) {
                v2 = Integer.parseInt(t2[j]);
                j++;
            }
            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
        }

        return 0;
    }
}