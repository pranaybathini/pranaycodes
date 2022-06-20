//https://leetcode.com/problems/compare-version-numbers
class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int max = Math.max(v1.length,v2.length);
        for(int i=0;i<max;i++){
            Integer c1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            Integer c2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            int result = c1.compareTo(c2);
            if(result != 0){
                return result;
            }
        }
        return 0;
    }
}
