class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] pr : prerequisites){
            preMap.computeIfAbsent(pr[0], k->new ArrayList<>());
            preMap.get(pr[0]).add(pr[1]);
        }
        for(int cr=0; cr<numCourses; cr++){
            if(!dfs(cr))    return false;
        }
        return true;
    }

    private boolean dfs(int cr){
        if(visit.contains(cr))  return false;
        if(preMap.get(cr)==null || preMap.get(cr).isEmpty())    return true;

        visit.add(cr);
        for(int pr:preMap.get(cr)){
            if(!dfs(pr))    return false;
        }
        visit.remove(cr);
        preMap.put(cr, new ArrayList<>());
        return true;
    }
}
