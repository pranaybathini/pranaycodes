//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            LongestPalindromicSubString ob = new LongestPalindromicSubString();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        Collections.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        subsetFill(arr,0,N-1,res,0);
        return res;
    }
    
    void subsetFill(ArrayList<Integer> arr, int l, int r, ArrayList<Integer> res, int sum){
        if(l>r){
            res.add(sum);
            return;
        }
        
        subsetFill(arr,l+1,r,res,arr.get(l)+sum);
        subsetFill(arr,l+1,r,res,sum);
    }
}
