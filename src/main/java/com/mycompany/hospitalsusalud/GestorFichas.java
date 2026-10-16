/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalsusalud;

/**
 *
 * @author vvictogo
 */
public class GestorFichas {
    private int contadorPreferenciales;
    private int contadorRegulares;
    public GestorFichas() {
        this.contadorPreferenciales=0;
        this.contadorRegulares=0;
    }
    public String generarFichaPreferencial(){
        contadorPreferenciales++;
        String ficha="P";
        if (contadorPreferenciales<10){
            ficha = "P"+"00"+ contadorPreferenciales;
        }
        else if  (contadorPreferenciales>=10 && contadorPreferenciales<100){
            ficha = "P"+"0"+ contadorPreferenciales;
        }
            else {
            ficha = "P"+ contadorPreferenciales;
        }return ficha;
        }
           public String generarFichaRegulares(){
        contadorRegulares++;
        String ficha="R";
        if (contadorRegulares<10){
            ficha = "R"+"00"+ contadorRegulares;
        }
        else if  (contadorRegulares>=10 && contadorRegulares<100){
            ficha = "R"+"0"+ contadorRegulares;
        }
            else {
            ficha = "R"+ contadorRegulares;
        }return ficha;
        }
    }
