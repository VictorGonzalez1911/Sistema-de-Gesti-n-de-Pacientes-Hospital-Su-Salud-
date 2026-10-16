/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;
import java.util.Date;
/**
 *
 * @author vvictogo
 */
public class GestionPacientes {
    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;
    private GestorFichas gestorDeFichas;

    public GestionPacientes() {
        this.colaRegular = new ColaPacientes();
        this.colaPreferencial = new ColaPacientes();
        this.gestorDeFichas = new GestorFichas();
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
}
    
    
    

