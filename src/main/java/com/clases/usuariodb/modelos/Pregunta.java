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
public class Pregunta {
    private int numero;
    private String pregunta;
    private String ruta;
    private int respuesta;

    public Pregunta(int numero, String pregunta, String ruta, int respuesta) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.ruta = ruta;
        this.respuesta = respuesta;
    }
    
      public Pregunta(String pregunta, String ruta, int respuesta) {
       
        this.pregunta = pregunta;
        this.ruta = ruta;
        this.respuesta = respuesta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }


    
}
