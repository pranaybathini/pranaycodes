// Problem - https://leetcode.com/problems/longest-palindromic-substring/

class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int max=0, idx=0;
        int len = s.length();
        if(len < 2) return s;
        
        for(int i=0;i<len;i++){
            int len1 = extend(s,i,i,len);
            int len2 = extend(s,i,i+1,len);
            if(max < Math.max(len1,len2)){
                idx = (len1>len2)? (i-len1/2) : (i-len2/2+1);
                max = Math.max(len1,len2);
            }
        }
        return s.substring(idx,idx+max);
    }
    
    public int extend(String s, int j, int k, int len){
        while(j>=0 && k < len && s.charAt(j) == s.charAt(k)){
            j--;k++;
        }
        return k-j-1;
    }
}
