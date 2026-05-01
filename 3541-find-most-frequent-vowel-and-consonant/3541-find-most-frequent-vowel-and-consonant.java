class Solution {
    public int maxFreqSum(String s) {
        int n = s.length();

        int []freq   = new int[5];
        int []consonant = new int[26];

        for(char ch:s.toCharArray()){
            if (ch == 'a') freq[0]++;
            else if (ch == 'e') freq[1]++;
            else if (ch == 'i') freq[2]++;
            else if (ch == 'o') freq[3]++;
            else if (ch == 'u') freq[4]++;
            else {
                consonant[ch-'a']++;
            }
        }
        int maxVowel = Arrays.stream(freq).max().getAsInt();
        int maxConsonant = Arrays.stream(consonant).max().getAsInt();
        return maxVowel+maxConsonant;
    }
}