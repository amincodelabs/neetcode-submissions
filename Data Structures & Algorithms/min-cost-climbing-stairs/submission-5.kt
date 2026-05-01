class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var downOne = 0
        var downTwo = 0
        
        // We iterate from the 2nd index to the end (representing the "top")
        for (i in 2..cost.size) {
            val temp = downOne
            // The cost to reach the current step is the min of the previous two options
            downOne = minOf(downOne + cost[i - 1], downTwo + cost[i - 2])
            downTwo = temp
        }
        
        return downOne
    }
}