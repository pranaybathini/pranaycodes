//https://leetcode.com/problems/palindromic-substrings/
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            int c1  = extend(i,i,s);
            int c2 = extend(i,i+1,s);
            count += c1+c2;
        }
        return count;
    }
    
    int extend(int j, int k, String s){
        int c=0;
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
            j--;k++;c++;
        }
        return c;
    }
}
