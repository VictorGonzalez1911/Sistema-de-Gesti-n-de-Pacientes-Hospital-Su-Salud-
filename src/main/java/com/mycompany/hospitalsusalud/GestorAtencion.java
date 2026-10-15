/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class GestorAtencion {

    private Cola preferenciales;
    private Cola regulares;
    private int preferencialesAtendidos;

    public GestorAtencion(Cola preferenciales, Cola regulares) {
        this.preferenciales = preferenciales;
        this.regulares = regulares;
        this.preferencialesAtendidos = 0;
    }

    public Pacientes atenderPaciente() throws Exception {

        boolean hayPreferenciales = !preferenciales.estaVacia();
        boolean hayRegulares = !regulares.estaVacia();

        if (!hayPreferenciales && !hayRegulares) {
            throw new Exception("No hay pacientes pendientes.");
        }

        // Si solo hay pacientes preferenciales
        if (hayPreferenciales && !hayRegulares) {
            if (preferencialesAtendidos < 2) {
                preferencialesAtendidos++;
            }

            return preferenciales.desencolar();
        }

        // Si solo hay pacientes regulares
        if (!hayPreferenciales && hayRegulares) {
            preferencialesAtendidos = 0;
            return regulares.desencolar();
        }

        // Si hay pacientes en ambas colas
        if (preferencialesAtendidos < 2) {
            preferencialesAtendidos++;
            return preferenciales.desencolar();
        } else {
            preferencialesAtendidos = 0;
            return regulares.desencolar();
        }
    }
}
