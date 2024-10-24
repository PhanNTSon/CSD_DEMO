
package Sort;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

    private T data;
    private Node next;
    private Node previous;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public T getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.getData());
    }

    @Override
    public String toString() {
        return "Node{" + "data= " + data + '}';
    }
}
