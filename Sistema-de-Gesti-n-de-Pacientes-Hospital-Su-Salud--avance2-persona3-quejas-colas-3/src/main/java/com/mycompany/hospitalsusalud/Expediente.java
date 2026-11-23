/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class Expediente {
    private String cedula;
    private String nombre;
    private int edad;
    private String genero;
    private ListaCitas historicoCitas;
    private ListaMedicamentos historicoMedicamentos;

    /**
     * @param cedula cedula del paciente
     * @param nombre nombre completo
     * @param edad edad en anos
     * @param genero genero del paciente
     */
    public Expediente(String cedula, String nombre, int edad, String genero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.historicoCitas = new ListaCitas();
        this.historicoMedicamentos = new ListaMedicamentos();
    }

    /** @return cedula */
    public String getCedula() { return cedula; }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @return edad */
    public int getEdad() { return edad; }

    /** @return genero */
    public String getGenero() { return genero; }

    /** @return historico de citas */
    public ListaCitas getHistoricoCitas() { return historicoCitas; }

    /** @return historico de medicamentos */
    public ListaMedicamentos getHistoricoMedicamentos() { return historicoMedicamentos; }

    /** Muestra cedula, nombre, edad y genero. */
    public void mostrarDatosPersonales() {
        System.out.println("Cedula: " + cedula);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Genero: " + genero);
    }
}

