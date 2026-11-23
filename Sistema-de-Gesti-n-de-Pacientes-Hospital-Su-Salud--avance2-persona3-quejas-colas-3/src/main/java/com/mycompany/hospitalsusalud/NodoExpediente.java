/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class NodoExpediente {
    private Expediente expediente;
    private NodoExpediente siguiente;
    private NodoExpediente anterior;

    /** @param expediente expediente que guarda el nodo */
    public NodoExpediente(Expediente expediente) { this.expediente = expediente; }

    /** @return expediente del nodo */
    public Expediente getExpediente() { return expediente; }

    /** @return siguiente nodo */
    public NodoExpediente getSiguiente() { return siguiente; }

    /** @return nodo anterior */
    public NodoExpediente getAnterior() { return anterior; }

    /** @param siguiente nodo siguiente */
    public void setSiguiente(NodoExpediente siguiente) { this.siguiente = siguiente; }

    /** @param anterior nodo anterior */
    public void setAnterior(NodoExpediente anterior) { this.anterior = anterior; }
}
    

