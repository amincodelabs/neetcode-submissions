// BFS
class Solution {
   public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        queue<TreeNode*> queue1;
        queue<TreeNode*> queue2;
        queue1.push(p);
        queue2.push(q);

        while (!queue1.empty() && !queue2.empty()) {
            for (int i = queue1.size(); i > 0; i--) {
                auto node1 = queue1.front();
                queue1.pop();
                auto node2 = queue2.front();
                queue2.pop();

                if (node1 == nullptr && node2 == nullptr) {
                    continue;
                }
                if (node1 == nullptr || node2 == nullptr || node1->val != node2->val) {
                    return false;
                }

                queue1.push(node1->left);
                queue1.push(node1->right);
                queue2.push(node2->left);
                queue2.push(node2->right);
            }
        }
        return true;
    }
};
