/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class BitacoraCitas {
    
    private NodoBitacora cabeza;

    /** @return true si no hay citas en la bitacora */
    public boolean estaVacia() { return cabeza == null; }

    /**
     * Inserta un registro ordenado por cedula (menor a mayor).
     * @param registro registro a insertar
     */
    public void insertar(RegistroBitacora registro) {
        NodoBitacora nuevo = new NodoBitacora(registro);
        if (estaVacia() || registro.getCedula().compareTo(cabeza.getRegistro().getCedula()) < 0) {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
            return;
        }
        NodoBitacora aux = cabeza;
        while (aux.getSiguiente() != null
                && aux.getSiguiente().getRegistro().getCedula()
                        .compareTo(registro.getCedula()) <= 0) {
            aux = aux.getSiguiente();
        }
        nuevo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevo);
    }

    /** Imprime la bitacora con colores segun el tiempo de espera. */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay citas registradas en el dia.");
            return;
        }
        String reset = "\u001B[0m";
        NodoBitacora aux = cabeza;
        while (aux != null) {
            System.out.println(aux.getRegistro().getColor() + aux.getRegistro() + reset);
            aux = aux.getSiguiente();
        }
        System.out.println();
        System.out.println("Verde: 1 a 30 s | Amarillo: mas de 30 s y menos de 1 min | Rojo: mas de 1 min");
    }
}
