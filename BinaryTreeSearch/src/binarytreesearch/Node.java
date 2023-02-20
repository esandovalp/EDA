/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytreesearch;

/**
 *
 * @author coron
 */
public class Node <T>{
    T val;
    Node left;
    Node right; 

    public Node(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    
    public Node(T val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
