class Solution {
    //O(n^2)
    //https://leetcode.com/problems/permutation-sequence/
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;i++){
            fact = fact*i;
            numbers.add(i);
        }
        numbers.add(n);
        k=k-1;
        String ans="";
        while(true){
            ans+=numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size()==0){
                break;
            }
            k = k%fact;
            fact = fact/numbers.size();
        }
        return ans;
    }
}
