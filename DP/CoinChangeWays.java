import java.util.Arrays;

public class CoinChangeWays {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int target = 5;
        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(ways4(arr, target, arr.length - 1, dp));
    }

  //Memoization + Recursion
    private static int ways(int[] arr, int target, int n, int[][] dp) {
        if (n == 0) {
            if (target % arr[n] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[n][target] != -1)
            return dp[n][target];

        int notPick = ways(arr, target, n - 1, dp);
        int pick = 0;
        if (arr[n] <= target) {
            pick = ways(arr, target - arr[n], n, dp);
        }

        return dp[n][target] = notPick + pick;
    }

  //Tabulation
    private static int ways2(int[] arr, int target, int n, int[][] dp) {
        for (int[] row : dp)
            Arrays.fill(row, 0);
        for (int j = 0; j <= target; j++) {
            if (j % arr[0] == 0) dp[0][j] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (arr[i] <= j) {
                    pick = dp[i][j - arr[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }
  
  //Two Array Space optimization

    private static int ways3(int[] arr, int target, int n, int[][] dp) {
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];
        for (int j = 0; j <= target; j++) {
            if (j % arr[0] == 0) prev[j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                curr[0] = 1;
                int notPick = prev[j];
                int pick = 0;
                if (arr[i] <= j) {
                    pick = curr[j - arr[i]];
                }
                curr[j] = pick + notPick;
            }
            prev = curr.clone();
        }

        for (int j = 0; j <= target; j++) {
            System.out.print(prev[j] + " ");
        }

        return 0;
    }

  //Single Array Space optimization
    private static int ways4(int[] arr, int target, int n, int[][] dp) {
        int[] prev = new int[target + 1];
        for (int j = 0; j <= target; j++) {
            if (j % arr[0] == 0) prev[j] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                prev[0] = 1;
                int notPick = prev[j];
                int pick = 0;
                if (arr[i] <= j) {
                    pick = prev[j - arr[i]];
                }
                prev[j] = pick + notPick;
            }
        }

        for (int j = 0; j <= target; j++) {
            System.out.print(prev[j] + " ");
        }

        return 0;
    }
}
