class TimeMap {

    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String[] strArr= new String[2];
        strArr[0]=value;
        strArr[1]=String.valueOf(timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(strArr);
    }
    
    public String get(String key, int timestamp) {
        List<String[]> list = map.get(key);
        if(list==null || list.isEmpty()) return "";
        int l=0, r=list.size()-1;
        if(list.isEmpty()) return "";
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            String[] strArr = list.get(mid);
            if(Integer.valueOf(strArr[1])==timestamp){
                return strArr[0];
            }else if(Integer.valueOf(strArr[1])>timestamp){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if (r < 0) return "";
        return list.get(r)[0];
    }
}
