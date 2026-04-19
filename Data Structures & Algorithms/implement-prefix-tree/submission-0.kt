class TrieNode {
    var word: Boolean = false  // isLeaf
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
}

class PrefixTree {
    
    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for(c in word) {
            if(c !in current.children) {
                current.children[c] = TrieNode()
            }
            current = current.children[c]!!
        }
        current.word = true
    }

    fun search(word: String): Boolean {
        var current = root
        for(c in word) {
            if(c !in current.children) {
                return false
            }
            current = current.children[c]!!
        }
        return current.word
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for (c in prefix) {
            if (c !in current.children) {
                return false
            }
            current = current.children[c]!!
        }
        return true
    }
}
