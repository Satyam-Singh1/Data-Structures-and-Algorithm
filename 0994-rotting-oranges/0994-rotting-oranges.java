class Solution {
    Queue<int[]> q = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int freshCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        int[][] direc = {
                { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }
        };
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if (grid[row][col] != 2) {
                    continue;
                }
                //explore neighbours
                for (int[] d : direc) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCnt--;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
            if (!q.isEmpty())min++;
        }
        return freshCnt == 0 ? min : -1;
    }
}