class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String temp = new String(chs);
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(str);
            map.put(temp,list);
        }
        return new ArrayList<>(map.values());
    }
}
