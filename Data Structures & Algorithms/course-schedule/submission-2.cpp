class Solution {
   public:
    // Create adj list as a map of (course, [prerequisite])
    unordered_map<int, vector<int>> prerequisitesMap;
    // Store all courses along the current DFS path
    unordered_set<int> visited;

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        // Map courses into hashmap
        for (int i = 0; i < numCourses; i++) {
            prerequisitesMap[i] = {};
        }
        for (const auto& prerequisite : prerequisites) {
            prerequisitesMap[prerequisite[0]].push_back(prerequisite[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }

        return true;
    }

    bool dfs(int course) {
        if (visited.count(course)) {
            // Cycle detected
            return false;
        }
        if(prerequisitesMap[course].empty()) {
            // Course has no prerequisites
            return true;
        }

        visited.insert(course);
        for(int prerequisite : prerequisitesMap[course]) {
            if(!dfs(prerequisite)) {
                return false;
            }
        }
        visited.erase(course);
        prerequisitesMap[course].clear();
        
        return true;
    }
};