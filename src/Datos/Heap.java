/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author fioro
 */
public class Heap {

    public class Nodo {

        /* Declaraciones de variables */
        private Ingreso persona;

        private Nodo padre;
        private Nodo hojaIzquierda;
        private Nodo hojaDerecha;

        /* Constructor */
        public Nodo(Ingreso valor) {
            this.persona = valor;
        }

        /* Setters y Getters */
        public void setValor(Ingreso valor) {
            this.persona = valor;
        }

        public Ingreso getValor() {
            return persona;
        }

        public Nodo getPadre() {
            return padre;
        }

        public void setPadre(Nodo padre) {
            this.padre = padre;
        }

        public Nodo getHojaIzquierda() {
            return hojaIzquierda;
        }

        public void setHojaIzquierda(Nodo hojaIzquierda) {
            this.hojaIzquierda = hojaIzquierda;
        }

        public Nodo getHojaDerecha() {
            return hojaDerecha;
        }

        public void setHojaDerecha(Nodo hojaDerecha) {
            this.hojaDerecha = hojaDerecha;
        }
    }
    /* Atributos */
    private Nodo raiz;

    /* Contructories */
    public Heap(Ingreso valor) {
        this.raiz = new Nodo(valor);
    }

    public Heap(Nodo raiz) {
        this.raiz = raiz;
    }

    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
      private void addNodo( Nodo nodo, Nodo raiz ) {
        /* 2.- Partiendo de la raíz preguntamos: Nodo == null ( o no existe ) ? */
        if ( raiz == null ) {
            /* 
             * 3.- En caso afirmativo X pasa a ocupar el lugar del nodo y ya 
             * hemos ingresado nuestro primer dato. 
             * ==== EDITO =====
             * Muchas gracias a @Espectro por la corrección de esta línea
             */
            this.setRaiz(nodo);
        }
        else {
            /* 4.- En caso negativo preguntamos: X < Nodo */
            if ( nodo.getValor().prioridad <= raiz.getValor().prioridad ) {
                /* 
                 * 5.- En caso de ser menor pasamos al Nodo de la IZQUIERDA del
                 * que acabamos de preguntar y repetimos desde el paso 2 
                 * partiendo del Nodo al que acabamos de visitar 
                 */
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                }
                else {
                    addNodo( nodo , raiz.getHojaIzquierda() );
                }
            }
            else {
                /* 
                 * 6.- En caso de ser mayor pasamos al Nodo de la DERECHA y tal
                 * cual hicimos con el caso anterior repetimos desde el paso 2
                 * partiendo de este nuevo Nodo.
                 */
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                }
                else {
                    addNodo( nodo, raiz.getHojaDerecha() );
                }
            }
        }
    }

    public void addNodo( Ingreso nodo ) {
        this.addNodo( new Nodo(nodo) , this.raiz );
    }
    
    public boolean delete(int value){
        Nodo current = this.raiz;
        Nodo parent = this.raiz;
        boolean isLeftChild = false;
        while(current.getValor().prioridad != value){
            parent = current;
            if(value < current.getValor().prioridad ){
                // Move to the left if searched value is less
                current = current.hojaIzquierda;
                isLeftChild = true;
            }
            else{
                // Move to the right if searched value is >=
                current = current.hojaDerecha;
                isLeftChild = false;
            }
            if(current == null){
                return false;
            }
        }
        // if reached here means node to be deleted is found
        
        // Leaf node deletion case
        if(current.hojaIzquierda == null && current.hojaDerecha == null){
            System.out.println("Leaf node deletion case");
            // if root node is to be deleted
            if(current == this.raiz){
                raiz = null;
            }
            // left child
            else if(isLeftChild){
                parent.hojaIzquierda = null;
            }
            // right child
            else{
                parent.hojaDerecha = null;
            }
        }
        // Node to be deleted has one child case
        // Node to be deleted has right child
        else if(current.hojaIzquierda == null){
            System.out.println("One right child deletion case");
            // if root node is to be deleted
            if(current == raiz){
                raiz = current.hojaDerecha;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaDerecha;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaDerecha;
            }
        }
        // Node to be deleted has left child
        else if(current.hojaDerecha == null){
            System.out.println("One left child deletion case");
            if(current == raiz){
                raiz = current.hojaIzquierda;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = current.hojaIzquierda;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = current.hojaIzquierda;
            }
        }
        // Node to be deleted has two children case
        else{
            System.out.println("Two children deletion case");
            // find in-order successor of the node to be deleted
            Nodo successor = findSuccessor(current);
            if(current == raiz){
                raiz = successor;
            }
            // if deleted node is left child
            else if(isLeftChild){
                parent.hojaIzquierda = successor;
            }
            // if deleted node is right child
            else{
                parent.hojaDerecha = successor;
            }
            successor.hojaIzquierda = current.hojaIzquierda;
        }
        return true;
    }
    private Nodo findSuccessor(Nodo node){
        Nodo successor = node;
        Nodo successorParent = node;
        // Start from the right child of the node to be deleted
        Nodo current = node.hojaDerecha;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.hojaIzquierda;
        }
        // When In-order successor is in the left subtree 
        // perform two ref changes here as we have 
        // access to successorParent
        if(successor != node.hojaDerecha){
            successorParent.hojaIzquierda = successor.hojaDerecha;
            // applicable only when successor is not right child
            // so doing here
            successor.hojaDerecha = node.hojaDerecha;
        }
        return successor;
    }


}
