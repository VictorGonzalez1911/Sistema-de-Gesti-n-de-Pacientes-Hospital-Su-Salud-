/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author XSF
 */
public class NodoQueja {

    private Queja queja;
    private NodoQueja siguiente;

    public NodoQueja() {
    }

    public NodoQueja(Queja queja) {
        this.queja = queja;
    }

    public Queja getQueja() {
        return queja;
    }

    public NodoQueja getSiguiente() {
        return siguiente;
    }

    public void setQueja(Queja queja) {
        this.queja = queja;
    }

    public void setSiguiente(NodoQueja siguiente) {
        this.siguiente = siguiente;
    }

}
