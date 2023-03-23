/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author coron
 */
public class BinaryTree <T extends Comparable<T>> {
    T data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public static <T> boolean isBST(BinaryTree guide, T min, T max) {
        if (guide == null)
            return true;
        
        if (guide.data.compareTo(guide.left.data) <= 0)
            return false;
        
        if (guide.data.compareTo(guide.right.data) >= 0)
            return false;
        
        return isBST(guide.right, (T) guide.data, max) && isBST(guide.left, min,(T) guide.data);
    }
    
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(6);
        root.left = new BinaryTree(3);
        root.right = new BinaryTree(9);
        root.left.left = new BinaryTree(1);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(7);
        root.right.right = new BinaryTree(11);
        
        if (isBST(root,Long.MIN_VALUE,Long.MAX_VALUE))
            System.out.println("It's a BST! ");
        else
            System.out.println("It's not :(");
    }
}
