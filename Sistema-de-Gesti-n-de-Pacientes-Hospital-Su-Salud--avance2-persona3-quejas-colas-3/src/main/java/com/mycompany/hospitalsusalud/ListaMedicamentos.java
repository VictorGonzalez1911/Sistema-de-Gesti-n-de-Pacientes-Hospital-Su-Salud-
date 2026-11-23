/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class ListaMedicamentos {
    private NodoMedicamento cabeza;
    private NodoMedicamento ultimo;

    /** @return true si no hay medicamentos */
    public boolean estaVacia() { return cabeza == null; }

    /**
     * Inserta un medicamento al final.
     * @param medicamento medicamento a insertar
     */
    public void insertar(Medicamento medicamento) {
        NodoMedicamento nuevo = new NodoMedicamento(medicamento);
        if (estaVacia()) {
            cabeza = nuevo;
            ultimo = nuevo;
            nuevo.setSiguiente(nuevo);
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(cabeza);
            ultimo = nuevo;
        }
    }

    /** Imprime todos los medicamentos registrados. */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("   Sin medicamentos registrados.");
            return;
        }
        NodoMedicamento aux = cabeza;
        int i = 1;
        do {
            System.out.println("   " + i + ". " + aux.getMedicamento());
            i++;
            aux = aux.getSiguiente();
        } while (aux != cabeza);
    }
    
}
