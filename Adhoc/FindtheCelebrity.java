
//O(n^2)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
         
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
         
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }
         
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
         
        return -1;
    }
}


//O(n) 
public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
         
        int left = 0;
        int right = n - 1;
         
        // Step 1: Find the potential candidate
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }
         
        // Step 2: Validate the candidate
        int candidate = right;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }
         
        return candidate;
    }
}
