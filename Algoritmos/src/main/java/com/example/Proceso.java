package com.example;

public class Proceso {
    private String Trabajo;
    private int rafagaCPU; // Ráfaga de CPU
    private int tiempoLlegada; // Tiempo de llegada
    private int prioridad; // Prioridad (opcional)

    // Constructor
    public Proceso(String nombre, int rafagaCPU, int tiempoLlegada) {
        this.Trabajo = nombre;
        this.rafagaCPU = rafagaCPU;
        this.tiempoLlegada = tiempoLlegada;
        this.prioridad = -1; // Default si no se usa
    }

    // Constructor con prioridad
    public Proceso(String nombre, int rafagaCPU, int tiempoLlegada, int prioridad) {
        this(nombre, rafagaCPU, tiempoLlegada);
        this.prioridad = prioridad;
    }

    // Getters
    public String getTrabajo() {
        return Trabajo;

    }

    public int getRafagaCPU() {
        return rafagaCPU;
    }

    public void setRafagaCPU(int rafagaCPU) {
        this.rafagaCPU = rafagaCPU;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getPrioridad() {
        return prioridad;
    }
}
