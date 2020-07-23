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
public class Aula {
    private int id;
    private String descripcion;
    private int edificio;
    private int estado;

    public Aula(int id, String descripcion, int edificio, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.edificio = edificio;
        this.estado = estado;
    }

    public Aula(String descripcion, int edificio, int estado) {
        this.descripcion = descripcion;
        this.edificio = edificio;
        this.estado = estado;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEdificio() {
        return edificio;
    }

    public void setEdificio(int edificio) {
        this.edificio = edificio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
