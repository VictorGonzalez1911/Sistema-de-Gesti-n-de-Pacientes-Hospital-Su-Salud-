package com.mycompany.hospitalsusalud;

import java.util.Scanner;

/**
 * Sistema de Gestion de Pacientes
 * Hospital Su Salud
 *
 * Persona 4 - Interfaz e Integracion
 */
public class HospitalSuSalud {

    // Scanner para leer las opciones ingresadas por el usuario
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        mostrarBienvenida();
        menuPrincipal();

    }

    // =========================================================
    // PB-15 - MENU PRINCIPAL
    // =========================================================
    public static void menuPrincipal() {

        int opcion = 0;

        do {

            System.out.println("\n========================================");
            System.out.println("          HOSPITAL SU SALUD");
            System.out.println("   Sistema de Gestion de Pacientes");
            System.out.println("========================================");
            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println();
            System.out.println("1. Gestionar Llegada de Pacientes");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {

                case 1:
                    menuGestionarLlegada();
                    break;

                case 2:
                    mostrarAyuda();
                    break;

                case 3:
                    salirSistema();
                    break;

                default:
                    System.out.println();
                    System.out.println("Opcion invalida.");
                    System.out.println("Por favor seleccione una opcion del 1 al 3.");
                    pausar();
                    break;
            }

        } while (opcion != 3);
    }

    // =========================================================
    // MENSAJE DE BIENVENIDA
    // =========================================================
    public static void mostrarBienvenida() {

        System.out.println("========================================");
        System.out.println("          HOSPITAL SU SALUD");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Bienvenido al Sistema de Gestion de Pacientes.");
        System.out.println("Este sistema permite gestionar la llegada");
        System.out.println("y atencion de los pacientes del hospital.");
        System.out.println();

        pausar();
    }

    // =========================================================
    // PB-16 - SUBMENU GESTIONAR LLEGADA
    // =========================================================
    public static void menuGestionarLlegada() {

        int opcion = 0;

        do {

            System.out.println("\n========================================");
            System.out.println("     GESTIONAR LLEGADA DE PACIENTES");
            System.out.println("========================================");
            System.out.println();
            System.out.println("1. Seleccionar Ficha");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Abandonar Cola de Pacientes");
            System.out.println("4. Mostrar Fichas Pendientes");
            System.out.println("5. Mostrar Quejas Recibidas");
            System.out.println("6. Regresar al Menu Principal");
            System.out.println();
            System.out.print("Seleccione una opcion: ");

            opcion = leerOpcion();

            switch (opcion) {

                case 1:
                    seleccionarFicha();
                    break;

                case 2:
                    atenderPaciente();
                    break;

                case 3:
                    abandonarCola();
                    break;

                case 4:
                    mostrarFichasPendientes();
                    break;

                case 5:
                    mostrarQuejas();
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Regresando al Menu Principal...");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opcion invalida.");
                    System.out.println("Seleccione una opcion del 1 al 6.");
                    pausar();
                    break;
            }

        } while (opcion != 6);
    }

    // =========================================================
    // OPCION 1 - SELECCIONAR FICHA
    // Se conectara con el modulo de Persona 1
    // =========================================================
    public static void seleccionarFicha() {

        System.out.println("\n========================================");
        System.out.println("          SELECCIONAR FICHA");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Esta opcion se conectara con el modulo");
        System.out.println("de seleccion y generacion de fichas.");
        System.out.println();
        System.out.println("Modulo correspondiente a Persona 1.");

        pausar();
    }

    // =========================================================
    // OPCION 2 - ATENDER PACIENTE
    // Se conectara con el modulo de Persona 2
    // =========================================================
    public static void atenderPaciente() {

        System.out.println("\n========================================");
        System.out.println("          ATENDER PACIENTE");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Esta opcion se conectara con el modulo");
        System.out.println("de atencion de pacientes.");
        System.out.println();
        System.out.println("Modulo correspondiente a Persona 2.");

        pausar();
    }

    // =========================================================
    // OPCION 3 - ABANDONAR COLA
    // Se conectara con el modulo de Persona 3
    // =========================================================
    public static void abandonarCola() {

        System.out.println("\n========================================");
        System.out.println("       ABANDONAR COLA DE PACIENTES");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Esta opcion se conectara con el modulo");
        System.out.println("para abandonar la cola y registrar");
        System.out.println("la queja correspondiente.");
        System.out.println();
        System.out.println("Modulo correspondiente a Persona 3.");

        pausar();
    }

    // =========================================================
    // PB-17 - MOSTRAR FICHAS PENDIENTES
    // =========================================================
    public static void mostrarFichasPendientes() {

        System.out.println("\n========================================");
        System.out.println("        FICHAS PENDIENTES");
        System.out.println("========================================");
        System.out.println();

        /*
         * Esta opcion sera integrada con las dos colas
         * desarrolladas por Persona 1:
         *
         * - Cola de pacientes preferenciales
         * - Cola de pacientes regulares
         *
         * Cuando las colas esten disponibles, aqui se
         * realizara el recorrido para mostrar las fichas
         * que se encuentran pendientes de atencion.
         */

        System.out.println("Pacientes Preferenciales:");
        System.out.println("Pendiente de integrar con la cola preferencial.");
        System.out.println();

        System.out.println("Pacientes Regulares:");
        System.out.println("Pendiente de integrar con la cola regular.");

        pausar();
    }

    // =========================================================
    // OPCION 5 - MOSTRAR QUEJAS
    // Se conectara con el modulo de Persona 3
    // =========================================================
    public static void mostrarQuejas() {

        System.out.println("\n========================================");
        System.out.println("          QUEJAS RECIBIDAS");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Esta opcion mostrara las quejas");
        System.out.println("almacenadas en la pila de quejas.");
        System.out.println();
        System.out.println("Modulo correspondiente a Persona 3.");

        pausar();
    }

    // =========================================================
    // PB-18 - AYUDA
    // =========================================================
    public static void mostrarAyuda() {

        System.out.println("\n========================================");
        System.out.println("                 AYUDA");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Sistema de Gestion de Pacientes");
        System.out.println("Hospital Su Salud");
        System.out.println();
        System.out.println("INSTRUCCIONES:");
        System.out.println();
        System.out.println("1. Gestionar Llegada de Pacientes:");
        System.out.println("   Permite ingresar al modulo principal");
        System.out.println("   para gestionar a los pacientes.");
        System.out.println();
        System.out.println("2. Seleccionar Ficha:");
        System.out.println("   Permite seleccionar una ficha regular");
        System.out.println("   o preferencial.");
        System.out.println();
        System.out.println("3. Atender Paciente:");
        System.out.println("   Permite atender a los pacientes");
        System.out.println("   que se encuentran en espera.");
        System.out.println();
        System.out.println("4. Abandonar Cola:");
        System.out.println("   Permite retirar a un paciente de la cola");
        System.out.println("   y registrar el motivo correspondiente.");
        System.out.println();
        System.out.println("5. Mostrar Fichas Pendientes:");
        System.out.println("   Muestra los pacientes que aun se");
        System.out.println("   encuentran pendientes de atencion.");
        System.out.println();
        System.out.println("6. Mostrar Quejas:");
        System.out.println("   Permite consultar las quejas recibidas.");
        System.out.println();
        System.out.println("Para utilizar el sistema, escriba el numero");
        System.out.println("de la opcion deseada y presione Enter.");

        pausar();
    }

    // =========================================================
    // PB-19 - SALIR DEL SISTEMA
    // =========================================================
    public static void salirSistema() {

        System.out.println("\n========================================");
        System.out.println("          HOSPITAL SU SALUD");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Gracias por utilizar el Sistema");
        System.out.println("de Gestion de Pacientes.");
        System.out.println();
        System.out.println("Hasta pronto.");
    }

    // =========================================================
    // METODO PARA LEER OPCIONES DE FORMA SEGURA
    // =========================================================
    public static int leerOpcion() {

        while (!teclado.hasNextInt()) {

            System.out.println();
            System.out.println("Entrada invalida.");
            System.out.print("Ingrese un numero: ");

            teclado.next();
        }

        int opcion = teclado.nextInt();
        teclado.nextLine();

        return opcion;
    }

    // =========================================================
    // METODO PARA PAUSAR LAS PANTALLAS
    // =========================================================
    public static void pausar() {

        System.out.println();
        System.out.println("Presione Enter para continuar...");
        teclado.nextLine();
    }
}