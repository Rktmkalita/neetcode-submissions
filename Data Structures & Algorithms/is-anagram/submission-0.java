class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] alphabets = new int[26];
        for(char ch : s.toCharArray()){
            alphabets[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            if(alphabets[ch-'a']==0){
                return false;
            }else{
                alphabets[ch-'a']--;
            }
        }
        return true;
    }
}
