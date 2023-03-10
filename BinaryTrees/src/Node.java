
import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    int height;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

class AVLTree {
    Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int val) {
        root = insertHelper(root, val);
    }

    private Node insertHelper(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val > node.val) {
            node.right = insertHelper(node.right, val);
        } else {
            return node; // duplicate values not allowed
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        Node temp = newRoot.left;

        newRoot.left = node;
        node.right = temp;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        return newRoot;
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        Node temp = newRoot.right;

        newRoot.right = node;
        node.left = temp;

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        return newRoot;
    }

    public void inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalHelper(root, result);
        System.out.println(result);
    }

    private void inOrderTraversalHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inOrderTraversalHelper(node.left, result);
        result.add(node.val);
        inOrderTraversalHelper(node.right, result);
    }

   public void print() {
    printHelper(root, "", true);
    }

    private void printHelper(Node node, String prefix, boolean isLeft) {
        if (node == null) 
        return;
    

    System.out.println(prefix + (isLeft ? "|-- " : "'-- ") + node.val);

    // Recursively print the left and right subtrees
    printHelper(node.left, prefix + (isLeft ? "|   " : "    "), true);
    printHelper(node.right, prefix + (isLeft ? "|   " : "    "), false);
}
    
     public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(25);
        tree.insert(1);

        System.out.println("In-order Traversal:");
        tree.inOrderTraversal();

        System.out.println("\nAVL Tree:");
        tree.print();
    }
}


