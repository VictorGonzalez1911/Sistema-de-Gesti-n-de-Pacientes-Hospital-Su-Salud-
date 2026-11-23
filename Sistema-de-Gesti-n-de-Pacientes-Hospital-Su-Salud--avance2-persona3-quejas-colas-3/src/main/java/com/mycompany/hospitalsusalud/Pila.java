/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author XSF
 */
public class Pila {
    private NodoQueja tope;

    public Pila() {
        this.tope = null;
    }

    public NodoQueja getTope() {
        return tope;
    }

    /** Agrega una queja al tope de la pila.
     * @param queja queja que se almacena
     */
    public void apilar(Queja queja) {
        if (queja == null) {
            throw new IllegalArgumentException("La queja no puede ser null.");
        }
        NodoQueja nuevoNodo = new NodoQueja(queja);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    /** Retira la queja mas reciente.
     * @return queja retirada
     * @throws Exception si la pila esta vacia
     */
    public Queja desapilar() throws Exception {
        if (this.estaVacia()) {
            throw new Exception("La pila esta vacia");
        }
        Queja quejaTope = tope.getQueja();
        tope = tope.getSiguiente();
        return quejaTope;
    }

    /** @return true si no existen quejas registradas */
    public boolean estaVacia() {
        return tope == null;
    }

    /** Muestra las quejas en orden LIFO sin eliminarlas. */
    public void imprimirPila() {
        if (this.estaVacia()) {
            System.out.println("No hay quejas registradas.");
            return;
        }
        NodoQueja actual = tope;
        while (actual != null) {
            System.out.println(actual.getQueja());
            actual = actual.getSiguiente();
        }
    }
}
