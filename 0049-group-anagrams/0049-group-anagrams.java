class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        Map<String, List<String>>map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String curr = strs[i];
            char []arr = curr.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String>value = map.getOrDefault(key,new ArrayList<>());
            value.add(curr);
            map.put(key,value);
        }
        return new ArrayList<>(map.values());
    }
}