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
public class ColaPrioridad<T>
{
   
    /**
     *
     */
    public Node<T> front;
	private Node<T> rear;

    /**
     *
     */
    public int size;
	
    /**
     *
     */
    public ColaPrioridad(){
		this.front = new Node<>();
		this.rear = this.front;
		this.size = 0;
	}
	
    /**
     *
     * @param element
     */
    public void enqueue(T element){
		this.rear.setNext(new Node<T>(element, null));
		this.rear = rear.getNext();
		this.size++;
	}
	
    /**
     *
     * @return
     */
    public T dequeue(){
		if(this.size == 0){
			System.out.println("Queue is empty");
			return null;
		}
		T temp = (T) this.front.getNext().getElement();
		Node<T> nTemp = this.front.getNext();
		this.front.setNext(nTemp.getNext());
		if (this.rear == nTemp){
			this.rear = this.front;
		}
		this.size--;
		return temp;
	}
	
    /**
     *
     * @return
     */
    public Object first(){
		if(this.size == 0){
			System.out.println("Queue is empty");
			return null;
		}
		return this.front.getNext().getElement();
	}
	
    /**
     *
     * @return
     */
    public int size(){
		return this.size;
	}
	
    /**
     *
     */
    public void clear(){
		this.front = new Node<>();
		this.rear = this.front;
		this.size = 0;
	}
	
    /**
     *
     * @return
     */
    public String toString(){
		String result = "**LQueue**\n";
		Node<T> tFront = this.front;
		int tSize = this.size;
		while(tSize != 0){
			result+= tFront.getNext().getElement() + " ";
			tFront = tFront.getNext();
			tSize--;
		}
		return result;
	}
    
    
}
