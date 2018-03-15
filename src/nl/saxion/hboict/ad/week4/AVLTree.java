package nl.saxion.hboict.ad.week4;

import java.lang.management.BufferPoolMXBean;

/**
 * You should only work in this file once you are comfortable with the implementation of BinarySearchTree!
 */
public class AVLTree extends BinarySearchTree {

    public AVLTree() {
        super();
    }

    @Override
    /**
     * This override is really required otherwise you can't create an AVL tree.
     */
    public BinarySearchTree makeTree() {
        return new AVLTree();
    }

    @Override
    /**
     * Do realise this is all that is required to transform a regular BST into a AVL Tree
     */
    public void insert(int value) {
        super.insert(value);
        rebalance();
    }

    public void delete(int value) {
        super.delete(value);
        rebalance();
    }

    /**
     * This is something you should focus on!
     */
    public void rebalance() {
        // TODO: (optional) Assignment 4!
    }

    public int getBalance() {
        // TODO: Assignment 3

        if (isEmpty()){
            return 0;
        }else{
            return leftChild.getHeight() - rightChild.getHeight();
        }
    }

    @Override
    /**
     * I've adjusted the output so you can actually read out the balance..
     */
    public String toDOTString() {
        String result = "";

        result += "\tn" + id + " [label=\"" + data + "(" + getBalance() + ")" + "\"];\n";

        if (leftChild != null && !leftChild.isEmpty()) {
            AVLTree lChild = (AVLTree) leftChild;
            result += "\tn" + lChild.getId() + " [label=\"" + lChild.getData() + "(" + lChild.getBalance() + ")" + "\"];\n";
            result += "\t" + "n" + id + " -> n" + lChild.getId() + "\n";
            result += lChild.toDOTString();
        }

        if (rightChild != null && !rightChild.isEmpty()) {
            AVLTree rChild = (AVLTree) rightChild;
            result += "\tn" + rChild.getId() + " [label=\"" + rChild.getData() + "(" + rChild.getBalance() + ")" + "\"];\n";
            result += "\t" + "n" + id + " -> n" + rChild.getId() + "\n";
            result += rChild.toDOTString();
        }

        return result;
    }
}
