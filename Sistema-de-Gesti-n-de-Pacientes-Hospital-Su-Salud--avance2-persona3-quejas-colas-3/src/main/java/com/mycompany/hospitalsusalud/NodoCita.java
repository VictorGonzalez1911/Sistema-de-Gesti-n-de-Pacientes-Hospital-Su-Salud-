/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class NodoCita {
    private Cita cita;
    private NodoCita siguiente;

    /** @param cita cita que guarda el nodo */
    public NodoCita(Cita cita) { this.cita = cita; }

    /** @return cita del nodo */
    public Cita getCita() { return cita; }

    /** @return siguiente nodo */
    public NodoCita getSiguiente() { return siguiente; }

    /** @param siguiente nodo siguiente */
    public void setSiguiente(NodoCita siguiente) { this.siguiente = siguiente; }
}
    

