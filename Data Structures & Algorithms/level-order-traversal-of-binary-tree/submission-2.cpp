// BFS
class Solution {
   public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == nullptr) return result;

        queue<TreeNode*> queue;
        queue.push(root);

        while (!queue.empty()) {
            vector<int> level;
            int size = queue.size();

            for (int i = size; i > 0; i--) {
                TreeNode* node = queue.front();
                queue.pop();

                if (node != nullptr) {
                    level.push_back(node->val);
                    if (node->left) queue.push(node->left);
                    if (node->right) queue.push(node->right);
                }
            }
            if (!level.empty()) {
                result.push_back(level);
            }
        }

        return result;
    }
};
