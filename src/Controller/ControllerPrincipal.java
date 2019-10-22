/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Datos.ColaPrioridad;
import Datos.Heap;
import Datos.Heap.Nodo;
import Datos.Ingreso;
import Datos.ListaSimple;
import Datos.Node;
import Datos.Vuelo;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author fioro
 */
public class ControllerPrincipal {

    /**
     *
     */
    public static ListaSimple Vuelos = new ListaSimple();

    /**
     *
     */
    public String tipo = "Colas";

    /**
     *
     */
    public int asignar = 0;

    /**
     *
     */
    public int puertas = 0;
    
    /**
     *
     */
    public static char[] lugar = {'V', 'C', 'P'};

    /**
     *
     * @param nombre
     * @param fecha
     * @param pasaporte
     * @param nacionalidad
     * @param origen
     * @param destino
     * @param planLealtad
     */
    public void CheckIn(String nombre, String fecha, String pasaporte, String nacionalidad, String origen, String destino, String planLealtad) {
        char asiento = planLealtad.toLowerCase().charAt(0);
        Random numero = new Random();
        int numero1 = numero.nextInt(3);
        char asiento2 = lugar[numero1];

        Vuelo vuelo = (Vuelo) Vuelos.consultar(destino);

        if (vuelo == null) {

            Vuelo nuevo = new Vuelo(destino);
            char Asiento = (char) (asiento + asiento2 + nuevo.getCantidad());
            nuevo.setCantidad(nuevo.getCantidad() + 1);
            Ingreso ingreso = new Ingreso(nombre, fecha, pasaporte, nacionalidad, origen, destino, planLealtad, Asiento);
            Heap arbol = nuevo.getArbol();
            arbol.addNodo(ingreso);
            switch (planLealtad.toLowerCase()) {
                case "economico":
                    nuevo.getEconomico().enqueue(ingreso);

                    break;
                case "oro":
                    nuevo.getOro().enqueue(ingreso);
                    break;
                case "platino":
                    nuevo.getPlatino().enqueue(ingreso);
                    break;
                case "especial":
                    nuevo.getEspecial().enqueue(ingreso);
                    break;
            }
            JOptionPane.showMessageDialog(null, "Ingresando... " + "\n"+ nombre + " al asiento " + Asiento+" con destino a "+destino);
            Vuelos.insertar(nuevo);

        } else {
            char Asiento = (char) (asiento + asiento2 + vuelo.getCantidad());
            Ingreso ingreso = new Ingreso(nombre, fecha, pasaporte, nacionalidad, origen, destino, planLealtad, Asiento);
            vuelo.setCantidad(vuelo.getCantidad() + 1);
            vuelo.getArbol().addNodo(ingreso);
            switch (planLealtad.toLowerCase()) {
                case "economico":
                    vuelo.getEconomico().enqueue(ingreso);
                    break;
                case "oro":
                    vuelo.getOro().enqueue(ingreso);
                    break;
                case "platino":
                    vuelo.getPlatino().enqueue(ingreso);
                    break;
                case "especial":
                    vuelo.getEspecial().enqueue(ingreso);
                    break;
            }
            JOptionPane.showMessageDialog(null, "Ingresando... " + "\n"+ nombre + " al asiento " + Asiento+" con destino a "+destino);
        }
        
        

    }

    /**
     *
     * @param vuelo
     */
    public void MostrarAtendidoCola(Vuelo vuelo) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            ColaPrioridad personas = vuelo.getEspecial();
            ColaPrioridad personas1 = vuelo.getOro();
            ColaPrioridad personas2 = vuelo.getPlatino();
            ColaPrioridad personas3 = vuelo.getEconomico();

            @Override

            public void run() {

                if (personas.size != 0) {

                    while (personas.size != 0) {

                        Ingreso temp = (Ingreso) personas.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());

                    }
                }
                if (personas1.size != 0) {

                    while (personas1.size != 0) {

                        Ingreso temp = (Ingreso) personas1.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());

                    }
                }
                if (personas2.size != 0)
                {

                    while (personas2.size != 0) 
                    {

                        Ingreso temp = (Ingreso) personas2.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());

                    }

                }
                if (personas3.size != 0)
                {

                    while (personas3.size != 0) 
                    {

                        Ingreso temp = (Ingreso) personas3.dequeue();
                        JOptionPane.showMessageDialog(null,"Atendiendo servicio "+temp.getServicio()+"\n"+temp.getNombre());

                    }
                }
            }};
                {

                }
                timer.schedule(task, 5000, 2000);
                Vuelos.eliminar(vuelo);
        }

    /**
     *
     * @return
     */
    public String getTipo() {
                return tipo;
            }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
                this.tipo = tipo;
            }

    /**
     *
     * @return
     */
    public int getPuertas() {
        return puertas;
    }

    /**
     *
     * @param puertas
     */
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    /**
     *
     * @return
     */
    public int getAsignar() {
        return asignar;
    }

    /**
     *
     * @param asignar
     */
    public void setAsignar(int asignar) {
        this.asignar = asignar;
    }

    /**
     *
     * @param vuelo
     */
    public void MostrarAtendidoArbol(Vuelo vuelo)
            {
               
                Timer timer = new Timer();

                TimerTask task = new TimerTask() 
                {
                    Heap arbol = vuelo.getArbol();
                   
                   @Override

                 public void run() 
                 {
                     Nodo temp = arbol.BuscarNodo(1);
                     Nodo temp1 = arbol.BuscarNodo(2);
                     Nodo temp2 = arbol.BuscarNodo(3);
                     Nodo temp3 = arbol.BuscarNodo(4);
                     while(temp!=null)
                     {
                         
                         arbol.delete(1);
                         JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getValor().getServicio() + "\n" + temp.getValor().getNombre());
                         temp = arbol.BuscarNodo(1);
                     }
                     while(temp1!=null)
                     {
                         arbol.delete(2);
                         JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp1.getValor().getServicio() + "\n" + temp1.getValor().getNombre());
                         temp1 = arbol.BuscarNodo(2);
                     }
                     while(temp2!=null)
                     {
                         arbol.delete(3);
                         JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp2.getValor().getServicio() + "\n" + temp2.getValor().getNombre());
                         temp2 = arbol.BuscarNodo(3);
                     }
                     while(temp3!=null)
                     {
                         arbol.delete(4);
                         JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp3.getValor().getServicio() + "\n" + temp3.getValor().getNombre());
                         temp3 = arbol.BuscarNodo(4);
                     }
                     
                 } 
                };
                {

                }
                timer.schedule(task, 5000, 2000);
                Vuelos.eliminar(vuelo);
            }
           

          
        }
