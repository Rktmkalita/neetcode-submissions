class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(int i=0; i<s1.length(); i++){
            s1Arr[s1.charAt(i)-'a']++;
            s2Arr[s2.charAt(i)-'a']++;
        }
        for(int i=s1.length();i<s2.length();i++){
            if(Arrays.equals(s1Arr,s2Arr))
                return true;
            s2Arr[s2.charAt(i)-'a']++;
            s2Arr[s2.charAt(i-s1.length())-'a']--;
        }
        return Arrays.equals(s1Arr,s2Arr);
    }
}
