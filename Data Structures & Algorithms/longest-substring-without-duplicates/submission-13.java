class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            char rch = s.charAt(r);
            if(map.containsKey(rch)){
                int pos=map.get(rch);
                if(pos>=l){
                    len=Math.max(len,r-l);
                    l=pos+1;
                }
            }
            map.put(rch,r);
            r++;
        }
        return Math.max(len,r-l);
    }
}
