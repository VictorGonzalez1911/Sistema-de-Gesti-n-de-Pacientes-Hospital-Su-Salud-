/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class Cola {
    private Nodo frente; // Referencia que apunta al primer elemento de la cola 
    private Nodo fin;    //

    public Cola() {
        this.frente = null;
        this.fin=null;
        
                
    }

    public Nodo getFrente() {
        return frente;
    }

    public Nodo getFin() {
        return fin;
    }
    
    
    public void encolar (Pacientes paciente){
         
        Nodo nuevoNodo =  new Nodo(paciente);
        if (this.fin !=null){ 
            
            this.fin.setSiguiente(nuevoNodo);  
        }
        fin = nuevoNodo; 
        
        if (this.estaVacia()){ 
            this.frente = nuevoNodo; 
        }
    }
    
    public Pacientes desencolar() throws Exception{
        
         
        
        if (this.estaVacia()){ 
            throw new Exception("La cola esta vacia"); 
            
        }
        
        Pacientes antiguoFrente = frente.getPaciente();
        frente = frente.getSiguiente(); 
        if (this.estaVacia()){ 
           fin = null;  
        }
        
        return antiguoFrente;
                
    }
    public boolean estaVacia(){
        return frente == null;
    }
    public void imprimirCola(){ 
        if (this.estaVacia()){
            System.out.println("La cola esta vacia: ");
        }
        Nodo actual = frente;
        
        while(actual != null){
            System.out.print(actual.getPaciente().getNumeroFicha()+ " - " +
            actual.getPaciente().getNombre() + "- " + actual.getPaciente().getCedula() + " | " );
            actual = actual.getSiguiente();
            System.out.println();
            
        }
        System.out.println();
    }
}
