class Solution {

    char separator = '#';

    public String encode(List<String> strs) {
        StringBuilder sbr = new StringBuilder();
        for(String str: strs){
            sbr.append(str.length());
            sbr.append(separator);
            sbr.append(str);
        }
        return sbr.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> result = new ArrayList<>();
        while(i<str.length()){
            int j=i;
            StringBuilder nbr = new StringBuilder();
            while(j<str.length() && str.charAt(j)!=separator){
                nbr.append(str.charAt(j));
                j++;
            }
            int len = Integer.parseInt(nbr.toString());
            i=j+1;
            j=i+len;
            result.add(str.substring(i,j));
            i=j;
        }
        return result;
    }
}
