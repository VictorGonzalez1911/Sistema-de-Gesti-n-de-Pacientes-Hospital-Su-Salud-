/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;
import java.util.*;
import java.util.Date;

/**
 *
 * @author vvictogo
 */
public class Pacientes {

    private String numeroFicha;
    private String cedula;
    private String nombre;
    private Date fechaLlegada;
    private boolean preferencial;

    public Pacientes() {
    }

    public Pacientes(String numeroFicha, String cedula, String nombre, Date fechaLlegada, boolean preferencial) {
        this.numeroFicha = numeroFicha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.preferencial = preferencial;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

}
