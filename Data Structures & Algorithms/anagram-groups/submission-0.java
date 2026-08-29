class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String temp = new String(chs);
            List<String> list = map.getOrDefault(temp, new ArrayList<>());
            list.add(strs[i]);
            map.put(temp,list);
        }
        return new ArrayList<>(map.values());
    }
}
