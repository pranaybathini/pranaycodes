//https://leetcode.com/problems/find-and-replace-in-string/
class FindReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<indices.length;i++){
            map.put(indices[i],i); 
        }
        
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(i)){
                sb.append(s.charAt(i));
                continue;
            }
            int index = map.get(i);
            if(!s.substring(i,i+sources[index].length()).equals(sources[index])){
                sb.append(s.charAt(i));
                continue;
            }
            i += sources[index].length()-1;
            sb.append(targets[index]);
        }
        return sb.toString();
    }
}
