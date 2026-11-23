/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class GestionExpedientes {
    
    private ListaExpedientes expedientes;
    private BitacoraCitas bitacora;

    /** Inicializa las estructuras vacias. */
    public GestionExpedientes() {
        this.expedientes = new ListaExpedientes();
        this.bitacora = new BitacoraCitas();
    }

    /** @return lista de expedientes */
    public ListaExpedientes getExpedientes() { return expedientes; }

    /** @return bitacora del dia */
    public BitacoraCitas getBitacora() { return bitacora; }

    /**
     * @param cedula cedula a buscar
     * @return expediente o null si no existe
     */
    public Expediente buscarExpediente(String cedula) {
        return expedientes.buscar(cedula);
    }

    /**
     * Crea un expediente y lo inserta ordenado.
     * @return expediente creado
     */
    public Expediente crearExpediente(String cedula, String nombre, int edad, String genero) {
        Expediente nuevo = new Expediente(cedula, nombre, edad, genero);
        expedientes.insertar(nuevo);
        return nuevo;
    }
}
