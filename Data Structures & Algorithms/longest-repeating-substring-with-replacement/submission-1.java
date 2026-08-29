class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> counter = new HashMap<>();
        int maxLen = 0;
        int l = 0;
        for(int r = 0; r<s.length(); r++){
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r),0)+1);
            int maxF = 0;
            for(int f : counter.values()){
                maxF = Math.max(maxF,f);
            }
            if(r-l+1-maxF>k){
                counter.put(s.charAt(l), counter.get(s.charAt(l))-1);
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
