class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // Create adj list as a map of (course, [prerequisite])
        val prerequisitesMap = HashMap<Int, MutableList<Int>>()
        for( course in 0 until numCourses) {
            prerequisitesMap[course] = mutableListOf()
        }
        for(p in prerequisites) {
            val (course, prerequisite) = p
            prerequisitesMap[course]!!.add(prerequisite)
        }

        val visited = HashSet<Int>()

        fun dfs(course: Int): Boolean {
            if(course in visited) return false // Cycle Detected

            val prerequisites = prerequisitesMap[course]!!
            if(prerequisites.isEmpty()) return true // The course has no prerequisit

            // Mark the current course as visited
            visited.add(course)

            // Visit all prerequisites of the current course
            for( prerequisite in prerequisites) {
                if(dfs(prerequisite) == false) return false
            }
            
            visited.remove(course)
            prerequisitesMap[course] = mutableListOf()
            return true
        }

        for(course in 0 until numCourses) {
            if(dfs(course) == false) return false
        }

        return true
    }
}
