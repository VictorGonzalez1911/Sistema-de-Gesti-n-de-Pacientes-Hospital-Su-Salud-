package com.mycompany.hospitalsusalud;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.hospitalsusalud.GestionPacientes;
import com.mycompany.hospitalsusalud.Pila;
import com.mycompany.hospitalsusalud.Pacientes;
import java.util.Date;

/**
 *
 * @author XSF
 */
public class GestionQuejas {
    private Pila quejas;

    public GestionQuejas() {
        this.quejas = new Pila();
    }

    public String abandonarCola(GestionPacientes gestionPacientes, String numeroFicha, String motivo) {
        Pacientes paciente = gestionPacientes.eliminarPacientePorFicha(numeroFicha);

        if (paciente == null) {
            return "No se encontro ningun paciente con la ficha " + numeroFicha + ".";
        }

        Queja queja = new Queja(
                paciente.getNumeroFicha(),
                paciente.getNombre(),
                paciente.getCedula(),
                motivo,
                new Date());
        quejas.apilar(queja);

        return "El paciente " + paciente.getNombre() + " (ficha " + paciente.getNumeroFicha()
                + ") abandono la cola. Queja registrada.";
    }

    public void mostrarQuejas() {
        quejas.imprimirPila();
    }
}
