package com.boredapeyachtclub.wallet.network;

import java.util.Vector;

public class BinaryTree {
    /**
     * @param root
     * @param type
     * @param leftLeaf
     * @param rightLeaf
     */
    public void nodeDepthFirstTraversal(Node root, int type, Vector<Integer> leftLeaf, Vector<Integer> rightLeaf) {
        if (root == null) {
            return;
        }
        /**
         * If tree consists of a single node
         */
        if (root.left == null && root.right == null) {
            if (type == -1) {
                System.out.print("Tree consists of a single node\n");
            } else if (type == 0) {
                leftLeaf.add(root.data);
            } else {
                rightLeaf.add(root.data);
            }

            return;
        }
        /**
         * If left child exists, traverse and set type to 0
         */
        if (root.left != null) {
            nodeDepthFirstTraversal(root.left, 0, leftLeaf, rightLeaf);
        }
        /**
         * If right child exists, traverse and set type to 1
         */
        if (root.right != null) {
            nodeDepthFirstTraversal(root.right, 1, leftLeaf, rightLeaf);
        }
    }

    /**
     *
     * @param leftLeaf
     * @param rightLeaf
     */
    public void debugLogging(Vector<Integer> leftLeaf,
                             Vector<Integer> rightLeaf) {
        if (leftLeaf.size() == 0 && rightLeaf.size() == 0)
            return;
        // Printing left leaf nodes
        System.out.print("Left leaf nodes\n");
        for (int x : leftLeaf) {
            System.out.print(x + " ");
        }
        System.out.println();
        // Printing right leaf nodes
        System.out.print("Right leaf nodes\n");
        for (int x : rightLeaf) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
