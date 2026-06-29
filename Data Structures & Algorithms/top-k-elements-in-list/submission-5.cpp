class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> count;
        for (int num : nums) {
            count[num]++;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;
        for (auto& [num, cnt] : count) {
            minHeap.push({cnt, num});
            if (minHeap.size() > k) {
                minHeap.pop();
            }
        }

        vector<int> result;
        for (int i = 0; i < k; i++) {
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }

        return result;
    }
};
