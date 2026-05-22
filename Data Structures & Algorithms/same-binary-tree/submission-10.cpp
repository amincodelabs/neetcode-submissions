// Iterative DFS
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
       stack<pair<TreeNode*, TreeNode*>> stack;
       stack.push({p, q});

       while(!stack.empty()) {
            auto [node1, node2] = stack.top();
            stack.pop();

            if(node1 == nullptr && node2 == nullptr) {
                continue;
            }
            if(node1 == nullptr || node2 == nullptr ||node1->val != node2->val) {
                return false;
            }

            stack.push({node1->right, node2->right});
            stack.push({node1->left, node2->left});
       }
        return true; 
    }
};
