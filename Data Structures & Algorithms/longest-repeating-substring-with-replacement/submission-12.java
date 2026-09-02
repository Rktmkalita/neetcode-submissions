class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int maxFrq = 0;
        int res = 0;
        int[] charMap = new int[26];
        while(r<s.length()){
            char ch = s.charAt(r);
            charMap[ch-'A']++;
            maxFrq = Math.max(maxFrq, charMap[ch-'A']);
            while(r-l+1 - maxFrq > k){
                charMap[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
