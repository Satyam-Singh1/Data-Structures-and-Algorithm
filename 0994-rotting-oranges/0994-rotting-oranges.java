class Solution {

    Queue<int[]> q = new LinkedList<>();

    public int[] bfs(int[][] grid , int freshCnt) { 

        int n = grid.length; // BUG FIX
        int m = grid[0].length; // BUG FIX

        int min = 0;

        int[][] direc = {
            {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rotted = false; // BUG FIX

            for (int k = 0; k < size; k++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int[] d : direc) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        freshCnt--;
                    }
                }
            }

            if (!q.isEmpty()) min++; // BUG FIX
        }

        return new int[]{freshCnt , min};
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0; // BUG FIX

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j}); // BUG FIX
                }

                else if (grid[i][j] == 1) {
                    fresh++; // BUG FIX
                }
            }
        }

        int []min = bfs(grid , fresh); // BUG FIX

        return min[0]==0?min[1]:-1;
    }

}