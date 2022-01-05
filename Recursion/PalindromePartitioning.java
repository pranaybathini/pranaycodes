//https://leetcode.com/problems/palindrome-partitioning/submissions/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        func(0,s,temp,list);
        return list;
    }
    
    public void func(int index, String s,List<String> temp, List<List<String>> list){
        if(index == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i=index;i<s.length();i++){
                if(isPalindrome(s,index,i)){
                    temp.add(s.substring(index,i+1));
                    func(i+1,s,temp,list);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    
    public boolean isPalindrome(String s, int st, int e){
        while(st<e){
            if(s.charAt(st++)!=s.charAt(e--)){
                return false;
            }
        }
        return true;
    }
}
