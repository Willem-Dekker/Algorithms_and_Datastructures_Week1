package nl.saxion.hboict.ad.week4;

/**
 * A simple recursive implementation of a Binary Search Tree (BST). This implementation uses "empty trees" as sentinals
 * An empty tree is represented by a BinarySearchTree object in which data, leftChild and rightChild all have a null reference
 * Each branch will have to end in an empty tree
 * A tree which has two children which both  are empty trees, is called a leaf.
 *
 * For simplicity reasons this implementation of BinarySearchTees only can have Integers as data member
 */
public class BinarySearchTree {

    // ID solely used for printing purposes.
    private static int lastAssignedId = 0;
    protected int id;

    // The data part of the tree. Only Integers can be stored
    protected Integer data;

    // References to both leftChild and rightChild children of this tree
    protected BinarySearchTree leftChild;
    protected BinarySearchTree rightChild;

    public BinarySearchTree() {
        data = null;
        leftChild = null;
        rightChild = null;

        id = lastAssignedId;
        lastAssignedId++;
    }

    /**
     * Factory-like method to provide a certain implementation of a BinarySearchTree.
     * You should override this method when creating an AVL tree.
     * @return An empty binary search tree
     */
    protected BinarySearchTree makeTree() {
        return new BinarySearchTree();
    }

    /**
     * Inserts a value at the correct spot in the tree.
     * This is done by first finding an empty tree and setting it's data attribute to value.
     * At that moment this empty tree has become a leaf  and therefor it must create new child tree's.
     * Note that
     * @param value The value that needs to be inserted
     */
    public void insert(int value) {
        if (isEmpty()){
            data = value;
            leftChild = makeTree();
            rightChild = makeTree();
        }else {
            if (value > data) {
                rightChild.insert(value);
            } else{
                leftChild.insert(value);
            }
        }

       // TODO: Assignment 1
    }

    /**
     * Removes value from the tree.
     * @param value The value that needs to be removed.
     */
    public void delete(int value) {
        if (isEmpty()) {
            // Nothing to delete here. value is not located in this tree
        } else if (data == value) {
            if (isLeaf()) {
                data = null;
                leftChild = null;
                rightChild = null;
            } else if (leftChild.isEmpty()) {
                copyRoot(rightChild);
            } else if (rightChild.isEmpty()) {
                copyRoot(leftChild);
            } else {
                BinarySearchTree smallTree = rightChild.findSmallest();
                data = smallTree.data;
                smallTree.delete(data);
            }
        } else if (value > data) {
            rightChild.delete(value);
        } else {
            leftChild.delete(value);
        }
    }

    /**
     * copy the complete contents of the root of tree tot this.
     * so this tree  node will be overwtritten by the contents of tree
     *
     * @param tree tree from which the root is copied
     */
    private void copyRoot(BinarySearchTree tree) {
        data = tree.data;
        leftChild = tree.leftChild;
        rightChild = tree.rightChild;
    }


    private BinarySearchTree findSmallest() {
        assert !isEmpty() : " to find a minimum tree can not be empty";

        BinarySearchTree minTree = this;

        while (!minTree.leftChild.isEmpty()) {
            minTree = minTree.leftChild;
        }

        return minTree;
    }

    /**
     * Helper method to be able to talk about empty trees
     * @return True if the tree does not contain any data.
     */
    public boolean isEmpty() {
        return data == null;
    }

    /**
     * Helper method to be able to talk about Leafs (a tree with only 1 data item).
     * @return True if the tree is a leaf.
     */
    protected boolean isLeaf() {
        return !isEmpty() && rightChild.isEmpty() && leftChild.isEmpty();
    }

    /**
     * Checks if a certain element is contained inside this tree.
     * @param value The value
     * @return True, if the value is in this tree, false if otherwise
     */
    public boolean contains(int value) {
        // TODO: Assignment 2
        if (!isEmpty()){
            if (data == value){
            return true;
            }else if(data > value){
                return leftChild.contains(value);
            }else if (data < value){
                return rightChild.contains(value);
            }
        }
        return false;
    }

    /**
     *
     * @return the distance from the root node to the leaf node
     */

    public int getHeight() {
        // Empty nodes shouldn't be counted.. so -1 for those!
        if(isEmpty()) {
            return -1;
        } else {
            return 1 + Math.max(leftChild.getHeight(), rightChild.getHeight());
        }
    }

    public Integer getData() {
        return data;
    }

    public int getId() {
        return id;
    }

    /**
     * Helper method which returns the graphviz String that can be used for visualizing this tree.
     * @return A part of the total graphviz string. See ApplicationWeek4 for its usage.
     */
    public String toDOTString() {
        String result = "";

        result += "\tn" + id + " [label=\"" + data + "\"];\n";

        if (leftChild != null && !leftChild.isEmpty()) {
            result += "\tn" + leftChild.getId() + " [label=\"" + leftChild.getData() + "\"];\n";
            result += "\t" + "n" + id + " -> n" + leftChild.getId() + "\n";
            result += leftChild.toDOTString();
        }

        if (rightChild != null && !rightChild.isEmpty()) {
            result += "\tn" + rightChild.getId() + " [label=\"" + rightChild.getData() + "\"];\n";
            result += "\t" + "n" + id + " -> n" + rightChild.getId() + "\n";
            result += rightChild.toDOTString();
        }

        return result;
    }

    public String toString() {
        return toDOTString();
    }
}
