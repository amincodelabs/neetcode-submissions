class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(char in s) {
            when(char) {
                '{', '(', '[' -> stack.add(char)
                '}', ')', ']' -> {
                    if(stack.isEmpty())
                        return false
                    val top = stack.removeLast()
                    if(
                        (char == '}' && top != '{') ||
                        (char == ')' && top != '(') ||
                        (char == ']' && top != '[') 
                    ) {
                            return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}
