/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases.usuariodb.modelos;

/**
 *
 * @author magb
 */
public class Mensajes {
    private int id;
    private String mensaje;
    private String fecha;
    

    public Mensajes(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Mensajes(int id, String mensaje, String fecha) {
        this.id = id;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }
   
    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
