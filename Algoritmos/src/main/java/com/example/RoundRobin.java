package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class RoundRobin {
    public static List<Resultado> ejecutar(List<Proceso> procesos, int quantum) {
        List<Resultado> resultados = new ArrayList<>();
        Queue<Proceso> cola = new LinkedList<>(procesos);
        int tiempoActual = 0;

        while (!cola.isEmpty()) {
            Proceso p = cola.poll();
            if (p.getTiempoLlegada() > tiempoActual) {
                tiempoActual = p.getTiempoLlegada();
            }

            int tiempoEspera = tiempoActual - p.getTiempoLlegada();
            int tiempoEjecutado = Math.min(p.getRafagaCPU(), quantum);
            tiempoActual += tiempoEjecutado;

            // Resta la ráfaga ejecutada
            p.setRafagaCPU(p.getRafagaCPU() - tiempoEjecutado);

            if (p.getRafagaCPU() > 0) {
                cola.add(p); // Reintegrar a la cola si no ha terminado
            } else {
                int tiempoRetorno = tiempoEspera + tiempoEjecutado;
                resultados.add(new Resultado(p.getTrabajo(), Math.max(tiempoEspera, 0), tiempoRetorno, p.getTiempoLlegada()));
            }
        }

        return resultados;
    }
}

