class NumMatrix {
    private int[][] prefixSum;
 public void findSum1(int n , int m ,int[][]pre ,  int [][]mat){
    for(int i = 0 ; i < n ; i++){
        int sum = mat[i][0];
        pre[i][0] = mat[i][0];
        for(int j = 1; j < m ; j++){
            sum+=mat[i][j];
            pre[i][j] = sum;
        }
    }
  }
public void findSum2(int n , int m , int[][] pre){
    for (int i = 0; i < m; i++) {
        for (int j = 1; j < n; j++) {
            pre[j][i] += pre[j - 1][i];  // Accumulate from top row down
        }
    }
}
    public NumMatrix(int[][] matrix) {
        int n  = matrix.length;
        int m = matrix[0].length;
         prefixSum = new int[matrix.length][matrix[0].length];
          findSum1(n , m ,prefixSum ,  matrix);
          findSum2(n , m , prefixSum);

        for(int[] prefix : prefixSum){
            System.out.println(Arrays.toString(prefix));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total =  prefixSum[row2][col2];
        int top = ( row1>0)?prefixSum[row1 - 1][col2]:0 ;
        int left = (col1>0)?prefixSum[row2][col1 - 1]:0;
        int common = (col1>0 && row1>0)?prefixSum[row1 - 1][col1 - 1]:0;
        return total - top-left + common;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */