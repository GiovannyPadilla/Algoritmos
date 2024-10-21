package com.example;

public class Resultado {
    private String nombre;
    private int tiempoEspera;
    private int tiempoRetorno;
    private int tiempoLlegada;

    public Resultado(String nombre, int tiempoEspera, int tiempoRetorno, int tiempoLlegada) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
        this.tiempoRetorno = tiempoRetorno;
        this.tiempoLlegada = tiempoLlegada;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }
}
