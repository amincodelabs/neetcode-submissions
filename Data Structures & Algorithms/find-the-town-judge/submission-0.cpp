class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        unordered_map<int, vector<int>> adj;

        // Create an empty trust list for every person.
        for (int person = 1; person <= n; person++) {
            adj[person] = vector<int>();
        }

        // Build adjacency list: person -> people they trust.
        for (auto& t : trust) {
            int from = t[0];
            int to = t[1];

            adj[from].push_back(to);
        }

        vector<int> candidates;

        // A judge candidate trusts nobody.
        for (auto& entry : adj) {
            int person = entry.first;
            vector<int>& trustedPeople = entry.second;

            if (trustedPeople.empty()) {
                candidates.push_back(person);
            }
        }

        if (candidates.empty()) {
            return -1;
        }

        // Check if every other person trusts the candidate.
        for (int candidate : candidates) {
            bool everyoneTrustsCandidate = true;

            for (auto& entry : adj) {
                int person = entry.first;
                vector<int>& trustedPeople = entry.second;

                // The judge does not need to trust themselves.
                if (person == candidate) {
                    continue;
                }

                auto it = find(
                    trustedPeople.begin(),
                    trustedPeople.end(),
                    candidate
                );

                if (it == trustedPeople.end()) {
                    everyoneTrustsCandidate = false;
                    break;
                }
            }

            if (everyoneTrustsCandidate) {
                return candidate;
            }
        }

        return -1;
    }
};