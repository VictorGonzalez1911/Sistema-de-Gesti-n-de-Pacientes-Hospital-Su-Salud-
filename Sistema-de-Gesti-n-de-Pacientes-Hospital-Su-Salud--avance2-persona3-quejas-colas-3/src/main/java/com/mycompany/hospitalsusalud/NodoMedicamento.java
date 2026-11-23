/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class NodoMedicamento {
    private Medicamento medicamento;
    private NodoMedicamento siguiente;

    /** @param medicamento medicamento que guarda el nodo */
    public NodoMedicamento(Medicamento medicamento) { this.medicamento = medicamento; }

    /** @return medicamento del nodo */
    public Medicamento getMedicamento() { return medicamento; }

    /** @return siguiente nodo */
    public NodoMedicamento getSiguiente() { return siguiente; }

    /** @param siguiente nodo siguiente */
    public void setSiguiente(NodoMedicamento siguiente) { this.siguiente = siguiente; }
    
}
