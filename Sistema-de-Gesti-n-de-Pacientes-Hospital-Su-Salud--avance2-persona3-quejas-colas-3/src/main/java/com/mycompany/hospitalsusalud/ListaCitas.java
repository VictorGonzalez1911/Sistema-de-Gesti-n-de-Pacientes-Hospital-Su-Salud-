/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class ListaCitas {
    private NodoCita cabeza;
    private NodoCita ultimo;

    /** @return true si no hay citas */
    public boolean estaVacia() { return cabeza == null; }

    /**
     * Inserta una cita al final para conservar el orden cronologico.
     * @param cita cita a insertar
     */
    public void insertar(Cita cita) {
        NodoCita nuevo = new NodoCita(cita);
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

    /** Imprime todas las citas registradas. */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("   Sin citas registradas.");
            return;
        }
        NodoCita aux = cabeza;
        int i = 1;
        do {
            System.out.println("   " + i + ". " + aux.getCita());
            i++;
            aux = aux.getSiguiente();
        } while (aux != cabeza);
    }
    
}
