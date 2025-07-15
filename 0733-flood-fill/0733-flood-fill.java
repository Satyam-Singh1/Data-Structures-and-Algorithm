class Solution {
    public void dfs(int r, int c, int color, int prevColor, int[][] image) {
        int n = image.length;
        int m = image[0].length;
        if (r < 0 || r > n - 1 || c < 0 || c > m - 1 || image[r][c] != prevColor) {
            return;
        }
       
       image[r][c] = color;
        

        //do the dfs call
        dfs(r + 1, c, color,prevColor, image);
        dfs(r - 1, c, color,prevColor, image);
        dfs(r, c + 1, color,prevColor, image);
        dfs(r, c - 1, color,prevColor, image);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
   
        int prevColor = image[sr][sc];
  if (prevColor == color) {
            return image;
        }
        dfs(sr, sc, color, prevColor, image);
        return image;

    }
}