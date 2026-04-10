class Solution {
    fun countSeniors(details: Array<String>): Int {
        var res = 0
        for (d in details) {
            val ten = d[11] - '0'
            val one = d[12] - '0'
            val age = one + 10 * ten
            if (age > 60) {
                res++
            }
        }
        return res
    }
}