/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T key;
    private Node<T> left;
    private Node<T> right;

    public Node(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * Compare Key of this Node to other Node (o).
     * @param o
     * @return 1 if This Node's key is larger other Node's key
     * -1 is Reverse and 0 if Equal
     */
    @Override
    public int compareTo(Node<T> o) {
        return this.key.compareTo(o.getKey());
    }
    
}
