//https://leetcode.com/problems/longest-valid-parentheses/
class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       boolean[] visited = new boolean[s.length()];
       for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '('){
               stack.push(i);
           }else if(s.charAt(i) ==')' && !stack.isEmpty()){
               visited[stack.pop()] = visited[i] = true;
           }
       }
        
       return getLongest(visited);
    }
    
    int getLongest(boolean[] visited){
        int max = 0, len=0;
        for(boolean item : visited){
            max = Math.max(max, len = (item?len+1 : 0));
        }
        return max;
    }
}
