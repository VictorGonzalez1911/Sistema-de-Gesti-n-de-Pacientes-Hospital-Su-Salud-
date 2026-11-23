package com.mycompany.hospitalsusalud;



import com.mycompany.hospitalsusalud.GestionQuejas;
import com.mycompany.hospitalsusalud.Pacientes;
import com.mycompany.hospitalsusalud.GestionPacientes;
import java.util.Scanner;
import java.sql.Timestamp;

/**
 *
 * Emily
 */
public class HospitalSuSalud {

    // Scanner para leer las opciones ingresadas por el usuario
    static Scanner teclado = new Scanner(System.in);

    static GestionPacientes gestionPacientes = new GestionPacientes();
    static GestionQuejas gestionQuejas = new GestionQuejas();
    static GestionExpedientes gestionExpedientes = new GestionExpedientes();

    public static void main(String[] args) {

        mostrarBienvenida();
        menuPrincipal();

    }

    //Menu Principal
    public static void menuPrincipal() {

        int opcion = 0;

        do {

            System.out.println("\n-----------------------------------------");
            System.out.println("          HOSPITAL SU SALUD :D ");
            System.out.println("   Sistema de Gestion de Pacientes");
            System.out.println("--------------------------------------------");
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

    // Mendasje de bienvenida
    public static void mostrarBienvenida() {

        System.out.println("----------------------------------------");
        System.out.println("          HOSPITAL SU SALUD");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Bienvenido al Sistema de Gestion de Pacientes.");
        System.out.println("Este sistema permite gestionar la llegada");
        System.out.println("y atencion de los pacientes del hospital.");
        System.out.println();

        pausar();
    }

    //Submenu de llegada
    public static void menuGestionarLlegada() {

        int opcion = 0;

        do {

            System.out.println("\n------------------------------------------");
            System.out.println("     GESTIONAR LLEGADA DE PACIENTES");
            System.out.println("------------------------------------------");
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

    // Seleccionar ficha
    public static void seleccionarFicha() {

        System.out.println("\n---------------------------------------");
        System.out.println("          SELECCIONAR FICHA");
        System.out.println("------------------------------------------");
        System.out.println();

        System.out.print("Tipo de paciente (1 = Regular, 2 = Preferencial): ");
        String tipo = teclado.nextLine().trim();

        if (!tipo.equals("1") && !tipo.equals("2")) {
            System.out.println();
            System.out.println("Tipo invalido.");
            pausar();
            return;
        }

        System.out.print("Cedula: ");
        String cedula = teclado.nextLine().trim();

        System.out.print("Nombre completo: ");
        String nombre = teclado.nextLine().trim();

        Pacientes paciente = new Pacientes();
        paciente.setCedula(cedula);
        paciente.setNombre(nombre);
        paciente.setPreferencial(tipo.equals("2"));

        gestionPacientes.registrarPaciente(paciente);

        System.out.println();
        System.out.println("Ficha asignada: " + paciente.getNumeroFicha());

        pausar();
    }

   /**
     * Atiende al siguiente paciente de la cola. Busca su expediente:
     * si es nuevo lo crea, si existe muestra sus datos. Solicita al doctor
     * los datos de la cita, el diagnostico y los medicamentos, y los guarda
     * en el expediente y en la bitacora del dia.
     */
    public static void atenderPaciente() {

        System.out.println("\n-------------------------------------");
        System.out.println("          ATENDER PACIENTE");
        System.out.println("-----------------------------------------");
        System.out.println();

        try {
            Pacientes atendido = gestionPacientes.atenderSiguiente();

            if (atendido == null) {
                System.out.println("No hay pacientes pendientes en ninguna cola.");
            } else {
                Timestamp fechaAtencion = new Timestamp(System.currentTimeMillis());
                Timestamp fechaLlegada = new Timestamp(atendido.getFechaLlegada().getTime());

                System.out.println("Ficha: " + atendido.getNumeroFicha());
                System.out.println("Nombre: " + atendido.getNombre());
                System.out.println("Tipo: " + (atendido.isPreferencial() ? "Preferencial" : "Regular"));
                System.out.println("Cedula: " + atendido.getCedula());
                System.out.println("Llegada: " + fechaLlegada);
                System.out.println();

                // B1: buscar expediente
                Expediente expediente = gestionExpedientes.buscarExpediente(atendido.getCedula());
                if (expediente == null) {
                    System.out.println("Paciente " + atendido.getNombre() + " asiste a consulta por primera vez.");
                    System.out.println();
                    System.out.println("--- Datos del expediente ---");
                    System.out.print("Edad: ");
                    int edad = leerOpcion();
                    System.out.print("Genero: ");
                    String genero = teclado.nextLine().trim();
                    expediente = gestionExpedientes.crearExpediente(
                            atendido.getCedula(), atendido.getNombre(), edad, genero);
                } else {
                    System.out.println("--- Datos del paciente ---");
                    expediente.mostrarDatosPersonales();
                }
                System.out.println();

                System.out.println("--- Datos de la cita ---");
                System.out.print("Nombre del doctor: ");
                String doctor = teclado.nextLine().trim();
                System.out.print("Diagnostico: ");
                String diagnostico = teclado.nextLine().trim();
                System.out.println();

                System.out.println("--- Medicamentos prescritos ---");
                System.out.print("Cantidad de medicamentos: ");
                int cantidad = leerOpcion();
                String[] medicamentos = new String[cantidad];
                for (int i = 0; i < cantidad; i++) {
                    System.out.print("Medicamento " + (i + 1) + ": ");
                    medicamentos[i] = teclado.nextLine().trim();
                }

                // B2: guardar la cita
                expediente.getHistoricoCitas().insertar(new Cita(fechaAtencion, doctor, diagnostico));

                // B3: guardar cada medicamento
                for (int i = 0; i < cantidad; i++) {
                    expediente.getHistoricoMedicamentos().insertar(
                            new Medicamento(fechaAtencion, medicamentos[i]));
                }

                // B4: guardar en la bitacora
                gestionExpedientes.getBitacora().insertar(new RegistroBitacora(
                        atendido.getNumeroFicha(), atendido.getCedula(), atendido.getNombre(),
                        fechaLlegada, fechaAtencion));

                System.out.println();
                System.out.println("Paciente " + atendido.getNombre() + ", su cita ha concluido.");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        pausar();
    }
    // Abandonar cola
    public static void abandonarCola() {

        System.out.println("\n-------------------------------------------");
        System.out.println("       ABANDONAR COLA DE PACIENTES");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.print("Numero de ficha: ");
        String ficha = teclado.nextLine().trim();

        System.out.print("Motivo del abandono: ");
        String motivo = teclado.nextLine().trim();

        String mensaje = gestionQuejas.abandonarCola(gestionPacientes, ficha, motivo);

        System.out.println();
        System.out.println(mensaje);

        pausar();
    }

    // Mostrar fichas


    public static void mostrarFichasPendientes() {

        System.out.println("\n-------------------------------------------");
        System.out.println("        FICHAS PENDIENTES");
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("Pacientes Preferenciales:");
        gestionPacientes.mostrarColaPreferencia();

        System.out.println("Pacientes Regulares:");
        gestionPacientes.mostrarColaRegular();

        pausar();
    }


    // Mostrar quejas

    public static void mostrarQuejas() {

        System.out.println("\n-------------------------------------------");
        System.out.println("          QUEJAS RECIBIDAS");
        System.out.println("-------------------------------------------");
        System.out.println();

        gestionQuejas.mostrarQuejas();

        pausar();
    }

    //ayuda

    public static void mostrarAyuda() {

        System.out.println("\n-------------------------------------------");
        System.out.println("                 AYUDA");
        System.out.println("-------------------------------------------");
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

    // Salir del sistema
    
    public static void salirSistema() {

        System.out.println("\n-------------------------------------------");
        System.out.println("          HOSPITAL SU SALUD");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Gracias por utilizar el Sistema");
        System.out.println("de Gestion de Pacientes.");
        System.out.println();
        System.out.println("Hasta pronto.");
    }

    // Metodo para leer
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


    // Metodo de pausar

    public static void pausar() {

        System.out.println();
        System.out.println("Presione Enter para continuar...");
        teclado.nextLine();
    }
}
