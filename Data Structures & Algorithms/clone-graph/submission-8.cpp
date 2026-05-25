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
// BFS
class Solution {
public:
    Node* cloneGraph(Node* node) {
      if(node == nullptr) {
        return nullptr;
      }

      unordered_map<Node*, Node*> hashMap;
      queue<Node*> queue;
      hashMap[node] = new Node(node->val);
      queue.push(node);

      while(!queue.empty()) {
        Node* current = queue.front();
        queue.pop();
        for(Node* nei : current->neighbors) {
            if(hashMap.find(nei) == hashMap.end()) {
                hashMap[nei] = new Node(nei->val);
                queue.push(nei);
            }
            hashMap[current]->neighbors.push_back(hashMap[nei]);
        }
      }

      return hashMap[node];
    }
};
