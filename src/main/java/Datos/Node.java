/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author fioro
 * @param <T>
 */
public class Node<T> {

    private T element;
    private Node next;

    //Constructores

    /**
     *
     */
    public Node() {
        this.element = null;
        this.next = null;
    }

    /**
     *
     * @param element
     */
    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    /**
     *
     * @param element
     * @param next
     */
    public Node(T element, Node next) {
        this.element = element;
        this.next = next;
    }

    //m�todos

    /**
     *
     * @return
     */
    public T getElement() {
        return this.element;
    }

    /**
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     *
     * @return
     */
    public Node getNext() {
        return this.next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

}
