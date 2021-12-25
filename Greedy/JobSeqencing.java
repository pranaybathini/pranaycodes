            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b)->(b.profit-a.profit));
        
        int max = 0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline > max){
                max = arr[i].deadline;
            }
        }
        //for storing the job sequence order
        int res[] = new int[max+1];
        
        for(int i=1;i<=max;i++){
            res[i] =-1;
        }
        
        int count=0, profit=0;
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(res[j]==-1){
                    res[j] = arr[i].id;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[]{count,profit};
    }
}
