package main.rice;

/**
 * Implementation of a single node in a doubly-linked list.
 *
 * @param <T> the type of element contained in the node
 */
public class Node<T> {

    /**
     * The data encapsulated in this node.
     */
    private T data;

    /**
     * The previous node in the list.
     */
    private Node<T> prev;

    /**
     * The next node in the list.
     */
    private Node<T> next;

    /**
     *
     * @param data
     */
    public Node(T data) {
        this.data = data;
    }

    /**
     * @return the data encapsulated by this node
     */
    public T getData() {
        return this.data;
    }

    /**
     * @return the previous node in the list
     */
    public Node<T> getPrev() {
        return this.prev;
    }

    /**
     * @return the previous node in the list
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Updates this node's prev to be the given node.
     *
     * @param prev the new previous node
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Updates this node's next to be the given node.
     *
     * @param next the new next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
