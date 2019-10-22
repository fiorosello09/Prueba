/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.util.Random;

/**
 *
 * @author fioro
 */
public class Vuelo
{

   
    private ColaPrioridad economico;
    private ColaPrioridad oro;
    private ColaPrioridad platino;
    private ColaPrioridad especial;
    private Heap arbol;
    private String destino;
    private int cantidad;
    private int vuelo;
    private int puerta;

    /**
     *
     * 
     * @param destino
     */
    public Vuelo(String destino) {
        this.economico = new ColaPrioridad();
        this.oro = new ColaPrioridad();
        this.platino = new ColaPrioridad();
        this.especial = new ColaPrioridad();
        this.arbol = new Heap();
        this.destino = destino;
        this.cantidad = 0;
        
    }

    /**
     *
     * @return
     */
    public ColaPrioridad getEconomico() {
        return economico;
    }

    /**
     *
     * @param economico
     */
    public void setEconomico(ColaPrioridad economico) {
        this.economico = economico;
    }

    /**
     *
     * @return
     */
    public ColaPrioridad getOro() {
        return oro;
    }

    /**
     *
     * @param oro
     */
    public void setOro(ColaPrioridad oro) {
        this.oro = oro;
    }

    /**
     *
     * @return
     */
    public ColaPrioridad getPlatino() {
        return platino;
    }

    /**
     *
     * @param platino
     */
    public void setPlatino(ColaPrioridad platino) {
        this.platino = platino;
    }

    /**
     *
     * @return
     */
    public ColaPrioridad getEspecial() {
        return especial;
    }

    /**
     *
     * @param especial
     */
    public void setEspecial(ColaPrioridad especial) {
        this.especial = especial;
    }

    /**
     *
     * @return
     */
    public String getDestino() {
        return destino;
    }

    /**
     *
     * @param destino
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     *
     * @return
     */
    public Heap getArbol() {
        return arbol;
    }

    /**
     *
     * @param arbol
     */
    public void setArbol(Heap arbol) {
        this.arbol = arbol;
    }

    /**
     *
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     */
    public int getVuelo() {
        return vuelo;
    }

    /**
     *
     * @param vuelo
     */
    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }

    /**
     *
     * @return
     */
    public int getPuerta() {
        return puerta;
    }

    /**
     *
     * @param puerta
     */
    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }
    
    
    
    
    
    
}
