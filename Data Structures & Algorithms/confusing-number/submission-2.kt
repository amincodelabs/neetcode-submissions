class Solution {
    fun confusingNumber(n: Int): Boolean {
        val invertMap = mapOf ('0' to '0', '1' to '1', '6' to '9',  '8' to '8', '9' to '6')
        val s = n.toString()
        val sb = StringBuilder()

        for(ch in s) {
            if(ch !in invertMap) {
                return false
            }
            sb.append(invertMap[ch])
        }

        return sb.reverse().toString().toInt() != n
    }
}
