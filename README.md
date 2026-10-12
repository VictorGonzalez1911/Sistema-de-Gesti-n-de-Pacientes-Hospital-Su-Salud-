package com.mycompany.hospitalsusalud.estructuras;

import com.mycompany.hospitalsusalud.modelo.Paciente;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

/**
 * Cola FIFO de pacientes. Se implementa con una deque, sin exponer su estado interno.
 */
public class ColaPacientes {
    private final Deque<Paciente> elementos = new ArrayDeque<>();

    public void encolar(Paciente paciente) {
        if (paciente == null) throw new IllegalArgumentException("El paciente no puede ser nulo.");
        elementos.addLast(paciente);
    }

    public Optional<Paciente> desencolar() {
        return Optional.ofNullable(elementos.pollFirst());
    }

    public Optional<Paciente> verPrimero() {
        return Optional.ofNullable(elementos.peekFirst());
    }

    public boolean estaVacia() { return elementos.isEmpty(); }
    public int tamanio() { return elementos.size(); }

    /** Devuelve una copia en orden FIFO; no permite alterar la cola original. */
    public List<Paciente> listar() { return new ArrayList<>(elementos); }
}
