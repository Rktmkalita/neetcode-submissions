class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set =  new HashSet<>();
        int left = 0, right=0;
        int maxLen = 0;
        while(left<n && right<n){
            char ch = s.charAt(right);
            while(set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            set.add(ch);
            right++;
        }
        return maxLen;
    }
}
