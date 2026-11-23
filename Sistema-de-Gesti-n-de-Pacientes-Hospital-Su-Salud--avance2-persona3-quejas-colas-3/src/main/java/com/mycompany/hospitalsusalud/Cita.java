/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;
import java.sql.Timestamp;
/**
 *
 * @author vvictogo
 */
public class Cita {
    private Timestamp fecha;
    private String doctor;
    private String diagnostico;

    /**
     * Crea una cita.
     * @param fecha fecha y hora de la cita
     * @param doctor nombre del doctor que atendio
     * @param diagnostico diagnostico en texto abierto
     */
    public Cita(Timestamp fecha, String doctor, String diagnostico) {
        this.fecha = fecha;
        this.doctor = doctor;
        this.diagnostico = diagnostico;
    }

    /** @return fecha de la cita */
    public Timestamp getFecha() { return fecha; }

    /** @return nombre del doctor */
    public String getDoctor() { return doctor; }

    /** @return diagnostico de la cita */
    public String getDiagnostico() { return diagnostico; }

    @Override
    public String toString() {
        return "Fecha: " + fecha + " | Doctor: " + doctor + " | Diagnostico: " + diagnostico;
    }
}
    

