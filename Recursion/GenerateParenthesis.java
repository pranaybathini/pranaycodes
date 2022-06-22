//https://leetcode.com/problems/generate-parentheses/
//BackTracking
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(ans, new StringBuilder(), 0 ,0 , n);
        return ans;
    }
    
    void bt(List<String> ans, StringBuilder curr, int open, int close, int n){
        if(curr.length() == n*2){
            ans.add(curr.toString());
            return;
        }
        
        if(open < n){
            curr.append("(");
            bt(ans,curr,open+1,close,n);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if(close < open){
            curr.append(")");
            bt(ans,curr,open,close+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
       
    }
}
