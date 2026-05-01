class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int n = stones.length();
        int res = 0;
        Map<Character,Integer>map = new HashMap<>();
        for(int i = 0 ; i < n  ; i++){
                char ch = stones.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = 0  ; i < jewels.length(); i++){
             char curr = jewels.charAt(i);
             if(map.containsKey(curr)){
             res+=map.get(curr);
             }
        }
        return res;
    }
}