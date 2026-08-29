class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1Arr = new int[26];
        for(char ch : s1.toCharArray()){
            s1Arr[ch-'a']++;
        }
        for(int l=0;l<=s2.length()-s1.length();l++){
            int[] s2Arr = new int[26];
            for(int r = l;r<l+s1.length(); r++){
                s2Arr[s2.charAt(r)-'a']++;
            }
            if(Arrays.equals(s1Arr,s2Arr)){
                return true;
            }
        }
        return false;
    }
}
