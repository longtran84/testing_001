package com.boredapeyachtclub.wallet.network;

import java.util.*;
import java.io.*;
import java.math.*;

public class VirusNetwork {
    /***
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numNodes = in.nextInt();
        int virusLocation = in.nextInt();
        int numLinks = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        BinaryTree binaryTree = new BinaryTree();
        Vector<Integer> leftLeaf = new Vector<Integer>();
        Vector<Integer> rightLeaf = new Vector<Integer>();

        for (int i = 0; i < numLinks; i++) {
            String link = in.nextLine();
            String[] indexNode = link.trim().split("\\s+");
            if (null != indexNode && indexNode.length > 1) {
                Node root = new Node(virusLocation);
                root.left = new Node(Integer.parseInt(indexNode[0]));
                root.right = new Node(Integer.parseInt(indexNode[1]));
                binaryTree.nodeDepthFirstTraversal(root, -1, leftLeaf, rightLeaf);
            } else {
                System.err.println("number of links within the network incorrect");
            }
        }
        binaryTree.debugLogging(leftLeaf, rightLeaf);
        System.out.println("answer");
    }
}
