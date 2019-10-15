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
public class Ingreso 
{
    String nombre;
    String fecha;
    int pasaporte;
    String nacionalidad;
    String origen;
    String destino;
    String servicio;
    char asiento;
    
    public Ingreso()
    {
        
    }
    
    public Ingreso(String pNombre, String pFecha,int pPasaporte,String pNacionalidad,String pOrigen,String pDestino,String pServicio,char asiento)
    {
        this.nombre = pNombre;
        this.fecha = pFecha;
        this.pasaporte = pPasaporte;
        this.nacionalidad = pNacionalidad;
        this.origen = pOrigen;
        this.destino = pDestino;
        this.servicio = pServicio;
        this.asiento = asiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(int pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    
    
    
}
