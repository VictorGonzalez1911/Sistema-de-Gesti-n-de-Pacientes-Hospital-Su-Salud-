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
public class RegistroBitacora {
    private String numeroFicha;
    private String cedula;
    private String nombrePaciente;
    private Timestamp fechaLlegada;
    private Timestamp fechaAtencion;

    /**
     * @param numeroFicha ficha del paciente
     * @param cedula cedula del paciente
     * @param nombrePaciente nombre del paciente
     * @param fechaLlegada hora en que saco la ficha
     * @param fechaAtencion hora en que fue atendido
     */
    public RegistroBitacora(String numeroFicha, String cedula, String nombrePaciente,
            Timestamp fechaLlegada, Timestamp fechaAtencion) {
        this.numeroFicha = numeroFicha;
        this.cedula = cedula;
        this.nombrePaciente = nombrePaciente;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
    }

    /** @return cedula del paciente */
    public String getCedula() { return cedula; }

    /** @return segundos que espero el paciente */
    public long getSegundosEspera() {
        return (fechaAtencion.getTime() - fechaLlegada.getTime()) / 1000;
    }

    /**
     * Color segun tiempo de espera: verde hasta 30 s,
     * amarillo de 31 a 59 s, rojo 60 s o mas.
     * @return codigo de color ANSI
     */
    public String getColor() {
        long s = getSegundosEspera();
        if (s <= 30) {
            return "\u001B[32m"; // verde
        } else if (s < 60) {
            return "\u001B[33m"; // amarillo
        } else {
            return "\u001B[31m"; // rojo
        }
    }

    @Override
    public String toString() {
        return "Ficha: " + numeroFicha + " | Cedula: " + cedula + " | Nombre: " + nombrePaciente
                + " | Llegada: " + fechaLlegada + " | Atencion: " + fechaAtencion
                + " | Espera: " + getSegundosEspera() + " s";
    }
    
}
