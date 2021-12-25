//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> data = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            data.add(new Meeting(start[i],end[i],i+1));
        }
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(data, mc);
        
        int ans = 1, endPos = data.get(0).end;
        for(int i=1;i<data.size();i++){
            if(data.get(i).start > endPos){
                ans++;
                endPos = data.get(i).end;
            }
        }
        
        return ans;
        
    }
}

class Meeting{
    int start;
    int end;
    int pos;
    public Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    

    public int compare(Meeting o1, Meeting o2){
        if(o1.end < o2.end){
            return -1;
        }else if(o1.end > o2.end){
            return 1;
        }else if(o1.pos < o2.pos){
            return -1;
        }
        return 1;
    }
}
