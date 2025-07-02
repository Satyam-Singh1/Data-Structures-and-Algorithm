class Solution {
    public boolean dfs(int i, int[][] arr, int[] vis, ArrayList<ArrayList<Integer>> list) {
        vis[i] = 1;
        for (int x : list.get(i)) {
            if (vis[x] == 0 && dfs(x, arr, vis, list)) {
                return true;
            } else if (vis[x] == 1)
                return true;
        }
        vis[i] = 2;
        return false;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            list.get(u).add(v);
        }

        //Topo sort -> IF cycle present then not possible
        //So simply check for cycle
        int[] vis = new int[numCourses];
     for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, prerequisites, vis, list)) {
                    return false;
                }
            }
        }
        return true;
    }
}