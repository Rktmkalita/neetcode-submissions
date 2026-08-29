class Solution {
    private static final String SEPARATOR = "####%SEPARATOR%####";
    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }
        String encodedString = "";
        for(String str: strs){
            encodedString += str + SEPARATOR;
        }
        System.out.println(encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        if(str.equals(SEPARATOR)){
            return Arrays.asList(new String[]{""});
        }
        if(str.equals(""))
            return Collections.emptyList();
        String[] arr = str.split(SEPARATOR);
        return Arrays.asList(arr);
    }
}
