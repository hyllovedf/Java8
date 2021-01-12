package com.df.dataStructure.tree.LeetCode.middle;

import com.df.dataStructure.tree.TreeNode;
import javafx.scene.transform.Rotate;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author hanyli
 * @date 2021/1/12
 */
public class BuildTree {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * 前序遍历第一个肯定是根节点  后面是左右子树的所有节点
     * [根节点, [左子树],[右子树]]
     * 中序遍历则是 [[左子树部分],根节点,[右子树部分]]
     *
     * 所以可以根据前序遍历找出根节点   然后根据根节点在中序遍历的位置确定左右子树的节点数
     * 通过递归构造出二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        //使用map存储后序序列节点对应的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1, 0, length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int pLeft,
                               int pRight, int iLeft, int iRight, Map<Integer, Integer> map) {
        if (pLeft > pRight || iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        Integer index = map.get(preorder[pLeft]);
        root.left = buildTree(preorder, pLeft + 1, index - iLeft + pLeft, iLeft, index - 1, map);
        root.right = buildTree(preorder, index - iLeft + pLeft + 1, pRight, index + 1, iRight, map);
        return root;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * 和前面的一样  只不过后序序列根节点在最后
     * [[左子树],[右子树],根节点]
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree2(postorder, 0, length - 1, 0, length - 1, map);
    }

    private TreeNode buildTree2(int[] postorder, int pleft, int pright,
                                int ileft, int iright, Map<Integer, Integer> map) {
        if (pleft > pright || ileft > iright) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pright]);
        Integer index = map.get(postorder[pright]);
        root.left = buildTree2(postorder, pleft, index - ileft + pleft-1, ileft, index - 1, map);
        root.right = buildTree2(postorder, index - ileft + pleft, pright-1 , index + 1, iright, map);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        buildTree.buildTree2(inorder, postorder);
    }
}
