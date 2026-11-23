/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class ListaExpedientes {
    private NodoExpediente cabeza;

    /** @return true si no hay expedientes */
    public boolean estaVacia() { return cabeza == null; }

    /** @return primer nodo (cedula menor) */
    public NodoExpediente getCabeza() { return cabeza; }

    /**
     * Busca un expediente por cedula.
     * @param cedula cedula a buscar
     * @return el expediente, o null si no existe
     */
    public Expediente buscar(String cedula) {
        if (estaVacia()) {
            return null;
        }
        NodoExpediente aux = cabeza;
        do {
            if (aux.getExpediente().getCedula().equals(cedula)) {
                return aux.getExpediente();
            }
            aux = aux.getSiguiente();
        } while (aux != cabeza);
        return null;
    }

    /**
     * Inserta un expediente en orden de cedula (menor a mayor).
     * @param expediente expediente a insertar
     */
    public void insertar(Expediente expediente) {
        NodoExpediente nuevo = new NodoExpediente(expediente);

        // Caso 1: lista vacia
        if (estaVacia()) {
            cabeza = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            return;
        }

        NodoExpediente ultimo = cabeza.getAnterior();

        // Caso 2: va antes de la cabeza (es el menor)
        if (expediente.getCedula().compareTo(cabeza.getExpediente().getCedula()) < 0) {
            nuevo.setSiguiente(cabeza);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
            return;
        }

        // Caso 3: buscar su posicion en medio o al final
        NodoExpediente aux = cabeza;
        while (aux.getSiguiente() != cabeza
                && aux.getSiguiente().getExpediente().getCedula()
                        .compareTo(expediente.getCedula()) < 0) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);
        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);
    }
}
