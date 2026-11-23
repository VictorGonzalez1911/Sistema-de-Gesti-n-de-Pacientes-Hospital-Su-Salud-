package com.mycompany.hospitalsusalud;

import java.util.Date;

/**
 * Gestiona el abandono de pacientes y conserva sus quejas en una pila LIFO.
 * Funcionalidad revisada para el Avance 2, Persona 3.
 */
public class GestionQuejas {
    private final Pila quejas;

    /** Inicializa la pila de quejas vacia. */
    public GestionQuejas() {
        this.quejas = new Pila();
    }

    /**
     * Retira un paciente de la cola correspondiente y registra una queja.
     * No registra quejas si la ficha es invalida o no se encuentra.
     *
     * @param gestionPacientes administrador de ambas colas
     * @param numeroFicha ficha del paciente que abandona
     * @param motivo motivo informado por el paciente
     * @return mensaje con el resultado de la operacion
     * @throws IllegalArgumentException si el administrador es null
     */
    public String abandonarCola(GestionPacientes gestionPacientes, String numeroFicha, String motivo) {
        if (gestionPacientes == null) {
            throw new IllegalArgumentException("La gestion de pacientes es obligatoria.");
        }
        if (numeroFicha == null || numeroFicha.trim().isEmpty()) {
            return "Debe ingresar un numero de ficha valido.";
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            return "Debe ingresar el motivo del abandono.";
        }
        Pacientes paciente = gestionPacientes.eliminarPacientePorFicha(numeroFicha.trim());
        if (paciente == null) {
            return "No se encontro ningun paciente con la ficha " + numeroFicha.trim() + ".";
        }
        Queja queja = new Queja(paciente.getNumeroFicha(), paciente.getNombre(),
                paciente.getCedula(), motivo.trim(), new Date());
        quejas.apilar(queja);
        return "El paciente " + paciente.getNombre() + " (ficha " + paciente.getNumeroFicha()
                + ") abandono la cola. Queja registrada.";
    }

    /** Imprime las quejas desde la mas reciente hasta la mas antigua. */
    public void mostrarQuejas() {
        quejas.imprimirPila();
    }

    /**
     * Devuelve la pila de quejas para consulta y pruebas.
     * @return pila de quejas registrada
     */
    public Pila getQuejas() {
        return quejas;
    }
}
