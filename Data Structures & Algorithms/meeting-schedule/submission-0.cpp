/**
 * Definition of Interval:
 * class Interval {
 * public:
 *     int start, end;
 *     Interval(int start, int end) {
 *         this->start = start;
 *         this->end = end;
 *     }
 * }
 */

class Solution {
   public:
    bool canAttendMeetings(vector<Interval>& intervals) {
        int n = intervals.size();

        for (int i = 0; i < n; i++) {
            Interval& a = intervals[i];
            for (int j = i + 1; j < n; j++) {
                Interval& b = intervals[j];
                if (min(a.end, b.end) > max(a.start, b.start)) {
                    return false;
                }
            }
        }

        return true;
    }
};
