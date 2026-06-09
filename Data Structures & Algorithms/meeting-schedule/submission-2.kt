/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        intervals.sortedBy { it.start }.let {
            for(i in 1 until it.size) {
                if(it[i - 1].end > it[i].start) {
                    return false
                }
            }
        }
        return true
    }
}
