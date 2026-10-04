class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer>map = new HashMap<>();
        int l = 0;
        int r =0;
        int maxLen  = 0;
        while(r<n){
            char curr = s.charAt(r);
            while(map.containsKey(curr)){
                char left = s.charAt(l);
                map.put(left, map.get(left)-1);
                if(map.get(left)==0) map.remove(left);
                l++;
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
            maxLen = Math.max(maxLen , r-l+1);
            r++;
        }
        return maxLen;
    }
}