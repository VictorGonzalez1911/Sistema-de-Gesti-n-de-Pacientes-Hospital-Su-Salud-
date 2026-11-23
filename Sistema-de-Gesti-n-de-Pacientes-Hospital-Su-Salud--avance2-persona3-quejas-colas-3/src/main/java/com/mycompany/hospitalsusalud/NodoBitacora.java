/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class NodoBitacora {
    private RegistroBitacora registro;
    private NodoBitacora siguiente;

    /** @param registro registro que guarda el nodo */
    public NodoBitacora(RegistroBitacora registro) { this.registro = registro; }

    /** @return registro del nodo */
    public RegistroBitacora getRegistro() { return registro; }

    /** @return siguiente nodo */
    public NodoBitacora getSiguiente() { return siguiente; }

    /** @param siguiente nodo siguiente */
    public void setSiguiente(NodoBitacora siguiente) { this.siguiente = siguiente; }
}
