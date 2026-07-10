class Solution {
   public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> result(n, 0);

        // Stores indices of days still waiting for a warmer temperature.
        stack<int> s;

        for (int currentDay = 0; currentDay < n; currentDay++) {
            // Today's temperature is warmer than the temperature
            // of the day at the top of the stack.
            while (!s.empty() && temperatures[currentDay] > temperatures[s.top()]) {
                int previousDay = s.top();
                s.pop();

                result[previousDay] = currentDay - previousDay;
            }

            // This day is now waiting for a warmer future day.
            s.push(currentDay);
        }

        return result;
    }
};