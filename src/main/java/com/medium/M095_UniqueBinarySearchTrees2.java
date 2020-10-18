package com.medium;

import com.domain.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class M095_UniqueBinarySearchTrees2 {
    public LinkedList<TreeNode> generate_trees2(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is choosen to be a root
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);

            // all possible right subtrees if i is choosen to be a root
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }

    public LinkedList<TreeNode> generate_trees(int start, int end){
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if(start > end){
            all_trees.add(null);
            return all_trees;
        }

        for(int i = start; i <= end; i++){
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
            for (TreeNode left_tree : left_trees) {
                for (TreeNode right_tree : right_trees) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = left_tree;
                    currentNode.right = right_tree;
                    all_trees.add(currentNode);
                }
            }
        }
        return all_trees;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }

    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    @Test
    public void t(){
        List<TreeNode> bt = generateTrees(3);
        for (TreeNode treeNode : bt) {
            inOrder(treeNode);
            System.out.println();
        }
    }

}
