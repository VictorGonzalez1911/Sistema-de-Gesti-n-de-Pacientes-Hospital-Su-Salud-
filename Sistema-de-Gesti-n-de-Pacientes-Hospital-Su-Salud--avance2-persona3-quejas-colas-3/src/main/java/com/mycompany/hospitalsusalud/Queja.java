package com.mycompany.hospitalsusalud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Date;

/**
 * 
 *
 * @author XSF 
 */
public class Queja {

    private String numeroFicha;
    private String nombrePaciente;
    private String cedula;
    private String motivo;
    private Date fechaHora;

    public Queja() {
    }

    public Queja(String numeroFicha, String nombrePaciente, String cedula, String motivo, Date fechaHora) {
        this.numeroFicha = numeroFicha;
        this.nombrePaciente = nombrePaciente;
        this.cedula = cedula;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return numeroFicha + " - " + nombrePaciente + " (" + cedula + ") | Motivo: " + motivo + " | Fecha: " + fechaHora;
    }
}
