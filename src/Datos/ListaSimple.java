/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fioro
 * @param <L>
 */
public class ListaSimple<L>
{
    

    // atributos de ListaFarmacia
    private Node<L> head;
    private Node<L> current;
    private Node<L> tail;
    private int cantidad;

    
    
    //constructor

    /**
     *
     */
        public ListaSimple()
    {
        this.head = new Node();
        this.current = this.head;
        this.tail = this.head;
        this.cantidad = 0; 
    }
    
    /**
     *
     * @return
     */
    public Node<L> getHead()
    {
        return head;
    }

    
    //algunos getters y setters

    /**
     *
     * @param head
     */
        public void setHead(Node<L> head) {
        this.head = head;
    }

    /**
     *
     * @return
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     *
     * @return
     */
    public L getElement()
    {
        return this.current.getElement();
    }
    
    
    //metodos
    
    
    //consulta la farmacia
    //debe retornar la farmacia
    
    /**
     *
     * @param nombreFarmacia
     * @return
     */
        
    public L consultar(L nombreFarmacia)
    {
        Node<L> nodoTemp = this.head;
        while(nodoTemp!=null)
        {
            L nombre  = nodoTemp.getElement();
            //System.out.println("temporaaaal"+nombre);
            //System.out.println("Elemento por buscar" +nombreFarmacia);
            if(nombre.equals(nombreFarmacia))
            {
                //System.out.println("entrooo");
                return nodoTemp.getElement();
                        
            }
            nodoTemp = nodoTemp.getNext();
        }
        System.out.println("No se encontro"); 
        return null;
    }
    
    //inserta la farmacia

    /**
     *
     * @param pElemento
     */
        public void insertar(L pElemento)
    {
        if (this.cantidad == 0) 
        {
            this.head = new Node<>(pElemento);
            this.current = this.head;
            this.tail = this.current;
            this.cantidad++;
            
        }
        else 
        {
            Node<L> objeto = new Node<>(pElemento);
            if (this.current == this.tail)
            {
               
                this.tail.setNext(objeto);
                this.tail = objeto;
                
                
            }
            this.current.setNext(objeto);
            //System.out.println("Current" +this.current.getElement());
            this.current = objeto;
            
            this.cantidad++;
            
        } 
    } 
    
    
    //elimina la farmacia ingresada

    /**
     *
     * @param pElemento
     */
        public void eliminar(L pElemento)
    {
        Node<L> temp = this.head;
        this.current = this.head;
        if(this.cantidad==0)
        {
            System.out.println("te mamaste guero");
        }
        while(temp!=null)
        {
            L objeto = temp.getElement();
            if(objeto.equals(pElemento))
            {
                if(temp == this.head)
                {
                    this.head = this.head.getNext();
                }
                if(this.current == this.tail)
                {
                    this.current = this.tail = temp;
                }
                this.current.setNext(temp.getNext());
            }
            temp = temp.getNext();
        }
        this.cantidad--;
        //System.out.println("No se encontro el elemento por eliminar");
           
    }

    /**
     *
     */
    public void clear()
    {
        this.head = this.tail = this.current = new Node();
        this.cantidad=0;
    }
    
    //imprime la lista (solo el nombre)

    /**
     *
     * @return
     */
        public String toString()
    {
        String lista = "";

        Node<L> currentNodo = this.head;

        while (currentNodo!=null)
        {
            lista +="(";
            
            lista += currentNodo;
            lista+= "), ";
            currentNodo = currentNodo.getNext();
        }
        return lista;
    }

   
    
   
    
    
        
    
    
}
   

