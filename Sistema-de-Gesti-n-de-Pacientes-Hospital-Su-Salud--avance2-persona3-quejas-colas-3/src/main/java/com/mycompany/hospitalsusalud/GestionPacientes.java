/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;
import com.mycompany.hospitalsusalud.ColaPacientes;
import com.mycompany.hospitalsusalud.Pacientes;
import java.util.Date;
/**
 *
 * @author vvictogo
 */
public class GestionPacientes {
    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;
    private GestorFichas gestorDeFichas;

    // Cuenta cuantos preferenciales seguidos se han atendido, para aplicar
    // la regla de 2 preferenciales : 1 regular (PB-07 a PB-09, Persona 2).
    private int preferencialesAtendidosSeguidos;

    public GestionPacientes() {
        this.colaRegular = new ColaPacientes();
        this.colaPreferencial = new ColaPacientes();
        this.gestorDeFichas = new GestorFichas();
        this.preferencialesAtendidosSeguidos = 0;
    }
    public Pacientes retirarPacienteRegular()throws Exception{
        return colaRegular.desencolar();
    }
    public Pacientes retirarPacientePreferencial() throws Exception{
        return colaPreferencial.desencolar();
    }
    public void registrarPaciente(Pacientes paciente){
        paciente.setFechaLlegada(new Date());
   if (paciente.isPreferencial()) {
        String ficha = gestorDeFichas.generarFichaPreferencial();
        paciente.setNumeroFicha(ficha);
        colaPreferencial.encolar(paciente);
    } else {
        String ficha = gestorDeFichas.generarFichaRegulares();
        paciente.setNumeroFicha(ficha);
        colaRegular.encolar(paciente);
    }
}
    public void mostrarColaRegular(){
        colaRegular.imprimirCola();
    }
    public void mostrarColaPreferencia(){
        colaPreferencial.imprimirCola();
    }
    public String seleccionarFichaRegular(){
        if (!colaRegular.estaVacia()){
            return colaRegular.getFrente().getPaciente().getNumeroFicha();

        }
        return null;
    }
    public String seleccionarFichaPreferencial(){
        if (!colaPreferencial.estaVacia()){
            return colaPreferencial.getFrente().getPaciente().getNumeroFicha();

        }
        return null;
    }

    /**
     * Atiende al siguiente paciente aplicando la regla de 2 pacientes
     * preferenciales por cada 1 regular (PB-08), respetando el orden FIFO
     * dentro de cada cola (PB-07, PB-09). Logica original de Persona 2,
     * adaptada aqui para trabajar sobre las colas de Persona 1.
     *
     * @return el paciente atendido, o null si ambas colas estan vacias
     */
    public Pacientes atenderSiguiente() throws Exception {
        boolean hayPreferencial = !colaPreferencial.estaVacia();
        boolean hayRegular = !colaRegular.estaVacia();

        if (!hayPreferencial && !hayRegular) {
            return null;
        }

        Pacientes atendido;
        if (!hayPreferencial) {
            atendido = colaRegular.desencolar();
            preferencialesAtendidosSeguidos = 0;
        } else if (!hayRegular) {
            atendido = colaPreferencial.desencolar();
            preferencialesAtendidosSeguidos++;
        } else if (preferencialesAtendidosSeguidos < 2) {
            atendido = colaPreferencial.desencolar();
            preferencialesAtendidosSeguidos++;
        } else {
            atendido = colaRegular.desencolar();
            preferencialesAtendidosSeguidos = 0;
        }
        return atendido;
    }

    /**
     * Busca un paciente por numero de ficha en ambas colas y lo elimina sin
     * alterar el orden de los demas (PB-12, PB-13 - Persona 3).
     *
     * @param numeroFicha ficha del paciente que abandona la cola
     * @return el paciente eliminado, o null si la ficha no existe en ninguna cola
     */
    public Pacientes eliminarPacientePorFicha(String numeroFicha) {
        if (numeroFicha == null || numeroFicha.trim().isEmpty()) {
            return null;
        }
        Pacientes paciente = colaRegular.eliminarPorFicha(numeroFicha);
        if (paciente == null) {
            paciente = colaPreferencial.eliminarPorFicha(numeroFicha);
        }
        return paciente;
    }
}
