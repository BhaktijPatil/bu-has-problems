package destiny.bu.problems.medium;

import destiny.bu.problems.easy.TreeNode;

import java.util.Arrays;

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */

public class ConstructBTreeFromTraversals {

    // PREORDER - NODE LEFT RIGHT
    // INORDER - LEFT NODE RIGHT

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        int rootInOrderIndex = getInOrderIndex(inorder, root);

        TreeNode treeNode = new TreeNode(root);

        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, rootInOrderIndex + 1), Arrays.copyOfRange(inorder, 0, rootInOrderIndex));

        treeNode.right = buildTree(Arrays.copyOfRange(preorder, rootInOrderIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootInOrderIndex + 1, inorder.length));

        return treeNode;
    }

    private int getInOrderIndex(int[] inorder, int root) {
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
