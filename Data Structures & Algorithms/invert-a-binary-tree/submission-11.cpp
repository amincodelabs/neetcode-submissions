// BFS
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(!root) {
            return nullptr;
        }

        std::queue<TreeNode*> queue;
        queue.push(root);

        while(!queue.empty()) {
            TreeNode* node = queue.front();
            queue.pop();
            swap(node->left, node->right);
            if(node->left) {
                queue.push(node->left);
            }
            if(node->right) {
                queue.push(node->right);
            }
        }

        return root;
    }
};
