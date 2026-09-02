class Solution {
    private int[] s1Arr = new int[26]; 
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int s1Length = s1.length();
        for(char ch : s1.toCharArray()){
            s1Arr[ch-'a']++;
        }
        int l=0,r=0;
        int[] s2Arr = new int[26];
        while(r<s2.length()){
            s2Arr[s2.charAt(r)-'a']++;
            if(r-l+1==s1Length){
                if(checkPresent(s2Arr)){ 
                    return true;
                }else{
                    s2Arr[s2.charAt(l)-'a']--;
                    l++;
                }
            }
            r++;
        }
        return false;
    }
    private boolean checkPresent(int[] s2Arr){
        for(int i=0; i<26; i++){
            if(s1Arr[i]==0) continue;
            if(s1Arr[i]!=s2Arr[i]){
                return false;
            }
        }
        return true;
    }
}
