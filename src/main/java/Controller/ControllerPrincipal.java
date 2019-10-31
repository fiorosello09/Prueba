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
import com.mycompany.api.SmsSender;
//import SmsSender.SmsSender;
import com.mycompany.api.api;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author fioro
 */
public class ControllerPrincipal {

    SmsSender mensaje = new SmsSender();

    /**
     *
     */
    public static double total = 0;

    /**
     *
     */
    public static double cont = 0;

    /**
     *
     */
    public static int PersonasColaSalida = 0;

    /**
     *
     */
    public static int PersonasAtendidasPuertas = 0;

    /**
     *
     */
    public static double totalPromedio = 0;

    /**
     *
     */
    public static double EsperaPromedioVIP = 0;

    /**
     *
     */
    public static double EsperaPromedioEs = 0;

    /**
     *
     */
    public static double EsperaPromedioE = 0;

    /**
     *
     */
    public static int AsientosPlanLealtadE = 0;

    /**
     *
     */
    public static int AsientosPlanLealtadEs = 0;

    /**
     *
     */
    public static int AsientosPlanLealtadVip = 0;

    api sentimiento = new api();
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
    public static int puertas = 0;

    /**
     *
     */
    public static String[] lugar = {"V", "C", "P"};

    /*
public static int PersonasPuertas = 0;
public static int AsientoPersona = 0;
public static int PersonasxPuertas = 0;
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
        PersonasAtendidasPuertas++;
        boolean plan = verificarPlan(planLealtad);
        if(plan==true)
        {
            planLealtad = planLealtad;
        }
        else
        {
            planLealtad = "economico";
        }
        char asiento = planLealtad.toLowerCase().charAt(0);
        Random numero = new Random();
        int numero1 = numero.nextInt(3);
        String asiento2 = lugar[numero1];

        Vuelo vuelo = (Vuelo) Vuelos.consultar(destino);

        if (vuelo == null) {

            Vuelo nuevo = new Vuelo(destino);
            String Asiento = asiento + asiento2 + nuevo.getCantidad();
            nuevo.setCantidad(nuevo.getCantidad() + 1);
            Ingreso ingreso = new Ingreso(nombre, fecha, pasaporte, nacionalidad, origen, destino, planLealtad, Asiento);
            Heap arbol = nuevo.getArbol();
            arbol.addNodo(ingreso);
            switch (planLealtad.toLowerCase()) {
                case "economico":
                    nuevo.getEconomico().enqueue(ingreso);
                    AsientosPlanLealtadE++; //sumador(PersonasPlanLealtad) +1 cada que ingrese al plan de lealtad

                    break;
                case "oro":
                    nuevo.getOro().enqueue(ingreso);
                    AsientosPlanLealtadVip++;
                    break;
                case "platino":
                    nuevo.getPlatino().enqueue(ingreso);
                    AsientosPlanLealtadVip++;
                    break;
                case "especial":
                    nuevo.getEspecial().enqueue(ingreso);
                    AsientosPlanLealtadEs++;
                    break;
            }
            JOptionPane.showMessageDialog(null, "Ingresando... " + "\n" + nombre + " al asiento " + Asiento + " con destino a " + destino);
            Vuelos.insertar(nuevo);
            mensaje.enviarMensaje("Su numero de asiento es " + Asiento);

        } else {
            String Asiento = (asiento + asiento2 + vuelo.getCantidad());
            Ingreso ingreso = new Ingreso(nombre, fecha, pasaporte, nacionalidad, origen, destino, planLealtad, Asiento);
            vuelo.setCantidad(vuelo.getCantidad() + 1);
            vuelo.getArbol().addNodo(ingreso);
            switch (planLealtad.toLowerCase()) {
                case "economico":
                    vuelo.getEconomico().enqueue(ingreso);
                    AsientosPlanLealtadE++; //sumador(PersonasPlanLealtad) +1 cada que ingrese al plan de lealtad
                    break;
                case "oro":
                    vuelo.getOro().enqueue(ingreso);
                    AsientosPlanLealtadVip++;
                    break;
                case "platino":
                    vuelo.getPlatino().enqueue(ingreso);
                    AsientosPlanLealtadVip++;
                    break;
                case "especial":
                    vuelo.getEspecial().enqueue(ingreso);
                    AsientosPlanLealtadEs++;
                    break;
            }
            JOptionPane.showMessageDialog(null, "Ingresando... " + "\n" + nombre + " al asiento " + Asiento + " con destino a " + destino);
            mensaje.enviarMensaje("Su numero de asiento es " + Asiento);
        }

    }

    /**
     *
     * @param vuelo
     * @throws java.lang.InterruptedException
     *
     */
    public void MostrarAtendidoCola(Vuelo vuelo) throws InterruptedException {
        Timer timer = new Timer();
        long inicio = System.currentTimeMillis();

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
                        PersonasColaSalida++;
                        EsperaPromedioEs++;
                        String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                        if (n != null) {
                            String comentario = n;

                            try {

                                String coment = conseguirSentimiento(comentario);
                                System.out.println(coment);
                                JOptionPane.showMessageDialog(null, coment);
                            } catch (Exception E) {
                                JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                            }

                        } else {
                        }
                    }
                }
                if (personas1.size != 0) {

                    while (personas1.size != 0) {

                        Ingreso temp = (Ingreso) personas1.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());
                        PersonasColaSalida++;
                        EsperaPromedioVIP++;
                        String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                        if (n != null) {
                            String comentario = n;
                            try {

                                String coment = conseguirSentimiento(comentario);
                                System.out.println(coment);
                                JOptionPane.showMessageDialog(null, coment);
                            } catch (Exception E) {
                                JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                            }
                        } else {
                        }
                    }
                }
                if (personas2.size != 0) {

                    while (personas2.size != 0) {

                        Ingreso temp = (Ingreso) personas2.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());
                        PersonasColaSalida++;
                        EsperaPromedioVIP++;
                        String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                        if (n != null) {
                            String comentario = n;
                            try {

                                String coment = conseguirSentimiento(comentario);
                                System.out.println(coment);
                                JOptionPane.showMessageDialog(null, coment);
                            } catch (Exception E) {
                                JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                            }
                        } else {
                        }
                    }

                }
                if (personas3.size != 0) {

                    while (personas3.size != 0) {

                        Ingreso temp = (Ingreso) personas3.dequeue();
                        JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getServicio() + "\n" + temp.getNombre());
                        PersonasColaSalida++;
                        EsperaPromedioE++;
                        String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                        if (n != null) {
                            String comentario = n;
                            try {

                                String coment = conseguirSentimiento(comentario);
                                System.out.println(coment);
                                JOptionPane.showMessageDialog(null, coment);
                            } catch (Exception E) {
                                JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                            }
                        } else {
                        }
                    }
                }
            }
        };
        {

        }
        Thread.sleep(2000);

        long fin = System.currentTimeMillis();

        double tiempo = (double) ((fin - inicio) / 1000);
        double tiempo1 = (double) ((fin - inicio) / 1000);
        double tiempo2 = (double) ((fin - inicio) / 1000);

        System.out.println(tiempo + " segundos");
        total = total + tiempo;
        totalPromedio = total / 3;
        cont++;
        ColaPrioridad personas = vuelo.getEspecial();
        ColaPrioridad personas1 = vuelo.getOro();
        ColaPrioridad personas2 = vuelo.getPlatino();
        ColaPrioridad personas3 = vuelo.getEconomico();

        if (EsperaPromedioE > 0 & personas3.size != 0) {
            EsperaPromedioE = tiempo;
        }

        if (EsperaPromedioVIP > 0 & personas2.size != 0 & personas1.size != 0) {
            EsperaPromedioVIP = tiempo1;
        }
        if (EsperaPromedioEs > 0 & personas.size != 0) {
            EsperaPromedioEs = tiempo2;
        }

        System.out.println(total + " segundos");
        System.out.println(cont + "atendidos");
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
    public void MostrarAtendidoArbol(Vuelo vuelo) {

        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            Heap arbol = vuelo.getArbol();

            @Override

            public void run() {
                Nodo temp = arbol.BuscarNodo(1);
                Nodo temp1 = arbol.BuscarNodo(2);
                Nodo temp2 = arbol.BuscarNodo(3);
                Nodo temp3 = arbol.BuscarNodo(4);
                while (temp != null) {

                    arbol.delete(1);
                    JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp.getValor().getServicio() + "\n" + temp.getValor().getNombre());
                    String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                    try {

                        String coment = conseguirSentimiento(n);
                        System.out.println(coment);
                        JOptionPane.showMessageDialog(null, coment);
                    } catch (Exception E) {
                        JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                    }
                    temp = arbol.BuscarNodo(1);
                }
                while (temp1 != null) {
                    arbol.delete(2);
                    JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp1.getValor().getServicio() + "\n" + temp1.getValor().getNombre());
                    String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                    if (n != null) {
                        String comentario = n;
                        try {

                            String coment = conseguirSentimiento(comentario);
                            System.out.println(coment);
                            JOptionPane.showMessageDialog(null, coment);
                        } catch (Exception E) {
                            JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                        }
                    } else {
                    }
                    temp1 = arbol.BuscarNodo(2);
                }
                while (temp2 != null) {
                    arbol.delete(3);
                    JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp2.getValor().getServicio() + "\n" + temp2.getValor().getNombre());
                    String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                    if (n != null) {
                        String comentario = n;
                        try {

                            String coment = conseguirSentimiento(comentario);
                            System.out.println(coment);
                            JOptionPane.showMessageDialog(null, coment);
                        } catch (Exception E) {
                            JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                        }
                    } else {
                    }
                    temp2 = arbol.BuscarNodo(3);
                }
                while (temp3 != null) {
                    arbol.delete(4);
                    JOptionPane.showMessageDialog(null, "Atendiendo servicio " + temp3.getValor().getServicio() + "\n" + temp3.getValor().getNombre());
                    String n = JOptionPane.showInputDialog(null, "Por favor escriba un comentario sobre el servicio", "");
                    if (n != null) {
                        String comentario = n;
                        try {

                            String coment = conseguirSentimiento(comentario);
                            System.out.println(coment);
                            JOptionPane.showMessageDialog(null, coment);
                        } catch (Exception E) {
                            JOptionPane.showMessageDialog(null, "favor ingresar un mensaje");
                        }
                    } else {
                    }
                    temp3 = arbol.BuscarNodo(4);
                }

            }
        };
        {

        }
        timer.schedule(task, 5000, 2000);
        Vuelos.eliminar(vuelo);
    }

    /**
     *
     * @param vuelo
     */
    public void MostrarEstadoPuerta(Vuelo vuelo) {
        String estructura = tipo;
        int cantidadEconomico = vuelo.getEconomico().size;
        int cantidadEspecial = vuelo.getEspecial().size;
        int cantidadOro = vuelo.getOro().size;
        int cantidadPlatino = vuelo.getPlatino().size();
        int cantidadAsientos = vuelo.getCantidad();
        String persona = "";
        if (cantidadEspecial != 0) {
            Node<Ingreso> cabeza = vuelo.getEspecial().front.getNext();
            persona = cabeza.getElement().getNombre();

        }
        if (cantidadOro != 0) {
            Node<Ingreso> cabeza = vuelo.getOro().front.getNext();
            persona = cabeza.getElement().getNombre();
        }
        if (cantidadPlatino != 0) {
            Node<Ingreso> cabeza = vuelo.getPlatino().front.getNext();
            persona = cabeza.getElement().getNombre();
        }
        if (cantidadEconomico != 0) {
            Node<Ingreso> cabeza = vuelo.getEconomico().front.getNext();
            persona = cabeza.getElement().getNombre();
        }
        JOptionPane.showMessageDialog(null, "Informacion de Puerta " + vuelo.getPuerta() + "\n" + "Estructura utilizada: " + estructura + "\n" + "Cantidad de personas especiales: " + cantidadEspecial + "\n" + "Cantidad de personas oro: " + cantidadOro + "\n" + "Cantidad de personas platino: " + cantidadPlatino + "\n" + "Cantidad de personas economico: " + cantidadEconomico
                + "\n" + "Siguiente persona por atender: " + persona + "\n" + "Cantidad de asientos otorgados: " + cantidadAsientos);

    }

    /**
     *
     * @param comentario
     * @return
     * @throws IOException
     */
    public String conseguirSentimiento(String comentario) throws IOException {
        String texto = sentimiento.api(comentario);
        return texto;
    }

    /**
     *
     * @param plan
     * @return
     */
    public boolean verificarPlan(String plan) {
        boolean bandera;
        String plan1 = plan.toLowerCase();
        if (plan1.equals("economico")) {
            bandera = true;
            return bandera;
        }
        if (plan1.equals("especial")) {
            bandera = true;
            return bandera;

        }
        if (plan1.equals("platino")) {
            bandera = true;
            return bandera;

        }
        if (plan1.equals("oro")) {
            bandera = true;
            return bandera;

        } else {
            bandera = false;
            return bandera;

        }

    }
    
    

}
