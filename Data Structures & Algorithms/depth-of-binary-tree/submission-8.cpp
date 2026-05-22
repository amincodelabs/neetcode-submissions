// Iterative DFS
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root) {
            return 0;
        }

        stack<pair<TreeNode*, int>> stack;
        stack.push({root, 1});
        int result = 0;

        while(!stack.empty()) {
            pair<TreeNode*, int> current = stack.top();
            stack.pop();
            TreeNode* node = current.first;
            int depth = current.second;

            if(node != nullptr) {
                result = max(result, depth);
                stack.push({node->left, depth + 1});
                stack.push({node->right, depth + 1});
            }
        }

        return result;
    }
};
