//https://leetcode.com/problems/decode-string/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> inStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k =0;
        for(Character c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + c-'0';
            }else if(c == '['){
                inStack.push(k);
                sbStack.push(curr);
                curr = new StringBuilder();
                k =0;
            }else if(c == ']' ){
                StringBuilder tmp = curr;
                curr = sbStack.pop();
                for(int i = inStack.pop();i>0;i--){
                    curr.append(tmp);
                }
            }else{
                curr.append(c);
            }
        }
        return curr.toString();
    
    }
}
