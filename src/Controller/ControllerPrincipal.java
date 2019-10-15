/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Datos.Ingreso;
import Datos.ListaSimple;
import Datos.Vuelo;


/**
 *
 * @author fioro
 */
public class ControllerPrincipal 
{
    public static ListaSimple Vuelos = new ListaSimple();

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
    public void CheckIn(String nombre, String fecha, String pasaporte, String nacionalidad,String origen, String destino, String planLealtad)
    {
        int pPasporte = Integer.parseInt(pasaporte);
        char asiento = planLealtad.toLowerCase().charAt(0);
        char asiento2 = 'c';
        char Asiento = (char) (asiento+asiento2);
        Vuelo vuelo = (Vuelo) Vuelos.consultar(destino);
        Ingreso ingreso = new Ingreso(nombre, fecha,pPasporte,nacionalidad, origen, destino, planLealtad,asiento); 
        if (vuelo==null)
        {
            Vuelo nuevo = new Vuelo(destino);
            switch(planLealtad.toLowerCase())
            {
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
         
        }
        else
        {
            switch(planLealtad.toLowerCase())
            {
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
        }
    
    }}
