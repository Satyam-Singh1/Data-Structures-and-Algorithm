class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int l = 0 , r=0;
        HashMap<Integer , Integer>map = new HashMap<>();
        int maxLen = 0 ;
        while(r<n){
            int curr = fruits[r];
              map.put(curr , map.getOrDefault(curr,0)+1);
              while(map.size()>2){
                 int left = fruits[l];
                 map.put(left, map.get(left)-1);
                 if(map.get(left)==0){ map.remove(left);}
                 l++;
              }
              int currLen = r-l+1;
              maxLen = Math.max(maxLen , currLen);
              r++;
        }
        return maxLen;
    }
}