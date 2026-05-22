// BFS
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(!root) {
            return 0;
        }

        std::queue<TreeNode*> queue;
        queue.push(root);
        int depth = 0;

        while(!queue.empty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode* node = queue.front();
                queue.pop();
                if(node->left) {
                    queue.push(node->left);
                }
                if(node->right) {
                    queue.push(node->right);
                }
            }
            depth++;
        }

        return depth;
    }
};
