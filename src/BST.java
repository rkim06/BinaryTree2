import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        BSTNode root = getRoot();
        return searchForValue(val, root);
    }
    public boolean searchForValue(int val, BSTNode root){
        if(root == null) {
            return false;
        }

        if(val > root.getVal()){
            return searchForValue(val, root.getRight());
        }
        else if(val < root.getVal()){
            return searchForValue(val, root.getLeft());
        }
        //if the values are the same, it has been found
        //not greater, less, or null must mean equal
        return true;

    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> arrNodes = new ArrayList<BSTNode>();

        inorder(root, arrNodes);
        return arrNodes;
    }
    public void inorder(BSTNode root, ArrayList<BSTNode> arrNodes){
        if(root == null){
            return;
        }
        else{
            //moves to traversing the left side of the tree
            inorder(root.getLeft(), arrNodes);

            //inorder has the root in the middle
            arrNodes.add(root);

            //moves to traversing the right side of the tree
            inorder(root.getRight(), arrNodes);
        }

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        // empty arrayList
        // method returns an arrayList of nodes
        ArrayList<BSTNode> arrNodes = new ArrayList<BSTNode>();

        preorder(root, arrNodes);
        return arrNodes;
    }
    public void preorder(BSTNode root, ArrayList<BSTNode> arrNodes){
        if(root == null){
            return;
        }
        //preorder starts with the roots and moves down
        arrNodes.add(root);

        //moves to traversing the left side of the tree
        preorder(root.getLeft(), arrNodes);

        //moves to traversing the right side of the tree
        preorder(root.getRight(), arrNodes);

    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        // empty arrayList
        // method returns an arrayList of nodes
        ArrayList<BSTNode> arrNodes = new ArrayList<BSTNode>();

        postorder(root, arrNodes);
        return arrNodes;
    }
    public void postorder(BSTNode root, ArrayList<BSTNode> arrNodes){

        if(root == null){
            return;
        }

        //moves to traversing the left side of the tree
        preorder(root.getLeft(), arrNodes);

        //moves to traversing the right side of the tree
        preorder(root.getRight(), arrNodes);

        //postorder ends with the root
        arrNodes.add(root);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        insertHelper(val, root);
    }
    public void insertHelper(int val, BSTNode root){
        //if the root is null
        //set new root equal to the val
        if(root == null){
            root = new BSTNode(val);
        }

        if(root.getVal() > val){
            //still have to check that the left nodes exist
            if(root.getLeft() == null){
                //if its null, then set the new node to the val
                root.setLeft(new BSTNode(val));
                return;
            }
            //recurses by continuing to get the next left node
            insertHelper(val, root.getLeft());
        }
        //same process as left side but just the right version
        else if(root.getVal() < val){
            if(root.getRight() == null){
                root.setRight(new BSTNode(val));
                return;
            }
            insertHelper(val, root.getRight());
        }
        return;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
