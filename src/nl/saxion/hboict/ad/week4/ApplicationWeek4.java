package nl.saxion.hboict.ad.week4;

/**
 * Demonstration of a BinarySearchTree.
 */
public class ApplicationWeek4 {

    public static void main(String[] args) {
        int[] dummyData = { 10, 5, 20, 15, 30, 25,  40, 60, 80 };
        BinarySearchTree myBST = new BinarySearchTree();


        for(int i : dummyData) {
            myBST.insert(i);
        }
       // printTree(myBST); // please uncomment when insert (see Assignment 1) has been implemented.
    }

    /**
     * Prints out the tree in graphviz format.
     * Insert this code in http://www.webgraphviz.com to see the actual tree.
     * @param bst The tree that needs to be printed
     */
    public static void printTree(BinarySearchTree bst) {
        String result = "digraph G {\n";
        result += bst.toDOTString();
        result += "}";

        System.out.println(result);
    }
}
