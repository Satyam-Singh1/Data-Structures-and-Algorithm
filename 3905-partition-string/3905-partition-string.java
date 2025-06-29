class Solution {
    public List<String> partitionString(String s) {
        int n = s.length();
        Set<String>set = new HashSet<>();
        List<String>ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
           str.append(s.charAt(i));
           if(!set.contains(str.toString())){
              ans.add(str.toString());
              set.add(str.toString());
              str.setLength(0);
           }
        }
      
        return ans;
    }
}