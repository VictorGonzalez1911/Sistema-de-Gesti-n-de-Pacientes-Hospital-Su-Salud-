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

    public void apilar(Queja queja) {
        NodoQueja nuevoNodo = new NodoQueja(queja);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public Queja desapilar() throws Exception {
        if (this.estaVacia()) {
            throw new Exception("La pila esta vacia");
        }
        Queja quejaTope = tope.getQueja();
        tope = tope.getSiguiente();
        return quejaTope;
    }

    public boolean estaVacia() {
        return tope == null;
    }

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
