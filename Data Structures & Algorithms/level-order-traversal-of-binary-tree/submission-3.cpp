// DFS
class Solution {
public:
    vector<vector<int>> result;

    vector<vector<int>> levelOrder(TreeNode* root) {
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode* node, int depth) {
        if(node == nullptr) return;

        if(result.size() == depth) {
            result.push_back(vector<int>());
        }
        result[depth].push_back(node->val);
        dfs(node->left, depth + 1);
        dfs(node->right, depth + 1);
    }
};
