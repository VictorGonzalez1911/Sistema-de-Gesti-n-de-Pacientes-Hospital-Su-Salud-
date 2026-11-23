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
public class Medicamento {
    private Timestamp fechaPrescripcion;
    private String nombre;

    /**
     * @param fechaPrescripcion fecha en que se receto
     * @param nombre nombre del medicamento
     */
    public Medicamento(Timestamp fechaPrescripcion, String nombre) {
        this.fechaPrescripcion = fechaPrescripcion;
        this.nombre = nombre;
    }

    /** @return fecha de prescripcion */
    public Timestamp getFechaPrescripcion() { return fechaPrescripcion; }

    /** @return nombre del medicamento */
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "Fecha: " + fechaPrescripcion + " | Medicamento: " + nombre;
    }
    
}
