class TrieNode {
    var isEndOfWord: Boolean = false
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
}

class PrefixTree {
    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (char in word) {
            // getOrPut automatically creates and inserts a new TrieNode if the char is missing
            current = current.children.getOrPut(char) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        // Safe call (?.) ensures we only check isEndOfWord if findNode doesn't return null
        return findNode(word)?.isEndOfWord == true
    }

    fun startsWith(prefix: String): Boolean {
        return findNode(prefix) != null
    }

    private fun findNode(str: String): TrieNode? {
        var current = root
        for (char in str) {
            // Elvis operator (?:) returns null immediately if the child isn't found
            current = current.children[char] ?: return null
        }
        return current
    }
}