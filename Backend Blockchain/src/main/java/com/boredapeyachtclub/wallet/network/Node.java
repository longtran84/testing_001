package com.boredapeyachtclub.wallet.network;

class Node {
    /**
     *
     */
    public int data;
    /**
     *
     */
    public Node left;
    /***
     *
     */
    public Node right;
    /***
     *
     * @param item
     */
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
