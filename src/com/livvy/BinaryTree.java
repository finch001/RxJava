package com.livvy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class BinaryTree {
    public static void main(String[] args) {
        Queue queue = new LinkedList<>();


    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode item = queue.poll();
            if (item.left != null) {
                queue.offer(item.left);
            } else if (item.right != null) {
                queue.offer(item.right);
            }
            lists.add(item.val);
        }
        return lists;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
