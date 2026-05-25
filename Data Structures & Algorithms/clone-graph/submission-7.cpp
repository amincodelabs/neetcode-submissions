/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
// Recursive DFS
class Solution {
   public:
    Node* cloneGraph(Node* node) {
        map<Node*, Node*> hashMap;
        return dfs(node, hashMap);
    }

   private:
    Node* dfs(Node* node, map<Node*, Node*>& hashMap) {
        if (node == nullptr) {
            return nullptr;
        }
        if (hashMap.count(node)) {
            return hashMap[node];
        }

        Node* clone = new Node(node->val);
        hashMap[node] = clone;

        for (Node* nei : node->neighbors) {
            clone->neighbors.push_back(dfs(nei, hashMap));
        }

        return clone;
    }
};
