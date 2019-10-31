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
    String pasaporte;
    String nacionalidad;
    String origen;
    String destino;
    String servicio;
    String asiento;
    int prioridad;
    
    /**
     *
     */
    public Ingreso()
    {
        
    }
    
    /**
     *
     * @param pNombre
     * @param pFecha
     * @param pPasaporte
     * @param pNacionalidad
     * @param pOrigen
     * @param pDestino
     * @param pServicio
     * @param asiento
     */
    public Ingreso(String pNombre, String pFecha,String pPasaporte,String pNacionalidad,String pOrigen,String pDestino,String pServicio,String asiento)
    {
        this.nombre = pNombre;
        this.fecha = pFecha;
        this.pasaporte = pPasaporte;
        this.nacionalidad = pNacionalidad;
        this.origen = pOrigen;
        this.destino = pDestino;
        this.servicio = pServicio;
        this.asiento = asiento;
        switch(pServicio.toLowerCase())
        {
            case "economico":
                this.prioridad = 4;
                break;
            case "especial":
                this.prioridad = 1;
                break;
            case "oro":
                this.prioridad = 2;
                break;
            case "platino":
                this.prioridad = 3;
                break;
        }
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getPasaporte() {
        return pasaporte;
    }

    /**
     *
     * @param pasaporte
     */
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    /**
     *
     * @return
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     *
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     *
     * @return
     */
    public String getOrigen() {
        return origen;
    }

    /**
     *
     * @param origen
     */
    public void setOrigen(String origen) {
        this.origen = origen;
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
    public String getServicio() {
        return servicio;
    }

    /**
     *
     * @param servicio
     */
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    /**
     *
     * @return
     */
    public String getAsiento() {
        return asiento;
    }

    /**
     *
     * @param asiento
     */
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    /**
     *
     * @return
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     *
     * @param prioridad
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    
}
