/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
   public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        // Store each value's index in inorder for O(1) lookup.
        for (int i = 0; i < inorder.size(); i++) {
            inorderIndex[inorder[i]] = i;
        }

        return build(preorder, 0, inorder.size() - 1);
    }

   private:
    unordered_map<int, int> inorderIndex;
    int preIndex = 0;

    TreeNode* build(vector<int>& preorder, int left, int right) {
        // No nodes exist in this inorder range.
        if (left > right) {
            return nullptr;
        }

        // Preorder always gives the next root.
        int rootValue = preorder[preIndex];
        preIndex++;
        TreeNode* root = new TreeNode(rootValue);

        // Inorder tells us where left and right subtrees are split.
        int mid = inorderIndex[rootValue];

        root->left = build(preorder, left, mid - 1);
        root->right = build(preorder, mid + 1, right);

        return root;
    }
};
