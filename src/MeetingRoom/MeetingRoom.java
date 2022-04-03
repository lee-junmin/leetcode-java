

/*
Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 
Example1
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation: (0,30), (5,10) and (0,30),(15,20) will conflict

Example2
Input: intervals = [(5,8),(9,15)]
Output: true
Explanation: Two times will not conflict 

 */

package MeetingRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MeetingRoom {
/*

need to sort based on the start time first 
then scan if there are any overlaps by comparing the end and start time of the next
sort TC is O(nlogn) and scanning is O(n) so the final TC is O(nlogn)

TC: O(nlogn)
SC: O(1)


 */
	
	
	public static boolean canAttendMeetings(List<Interval> intervals) {
        int len = intervals.size();
		// we first sort the list
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        
        // then scan through until we find a overlap
		for (int i=0; i<len-1; i++) {
			if (intervals.get(i).end > intervals.get(i+1).start) {
				return false;
			}
		}
		return true;
    }
	
	
	// driver
	public static void main(String[] args) {
		
		Interval i1 = new Interval(1,5);
		Interval i2 = new Interval(4,10);
		Interval i3 = new Interval(15,20);
		
		List<Interval> input = new ArrayList<Interval>();
		input.add(i1);
		input.add(i2);
		input.add(i3);
		
		
		boolean result = canAttendMeetings(input);
		System.out.println(result);

		
	
		
		
	}

}


/*
public boolean canAttendMeetings(List<Interval> intervals) {
    int n = intervals.size();
    if(n == 0 || n == 1) return true;
    Collections.sort(intervals, (a,b) -> a.start - b.start);
    
    Interval temp = intervals.get(0);
    for(int i = 1; i < n; i++){
        Interval current = intervals.get(i);
        if(current.start < temp.end) return false;
        temp = current;
    }
    return true;
}
*/