// Iterative DFS
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;
        std::stack<TreeNode*> stack;
        stack.push(root);

        while(!stack.empty()) {
            TreeNode* node = stack.top();
            stack.pop();
            swap(node->left, node->right);
            if(node->left) {
                stack.push(node->left);
            }
            if(node->right) {
                stack.push(node->right);
            }
        }

        return root;
    }
};
