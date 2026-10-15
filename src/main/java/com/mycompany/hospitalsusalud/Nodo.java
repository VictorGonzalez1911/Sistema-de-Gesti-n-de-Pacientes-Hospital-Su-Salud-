/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class Nodo {

    private Pacientes paciente;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(Pacientes paciente) {
        this.paciente = paciente;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
    

