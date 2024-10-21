package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Prioridad {
    public static List<Resultado> ejecutar(List<Proceso> procesos) {
        List<Resultado> resultados = new ArrayList<>();
        int tiempoActual = 0;

        // Ordenar procesos por tiempo de llegada y prioridad
        procesos.sort(Comparator.comparingInt(Proceso::getTiempoLlegada)
                .thenComparingInt(Proceso::getPrioridad));

        for (Proceso p : procesos) {
            if (tiempoActual < p.getTiempoLlegada()) {
                tiempoActual = p.getTiempoLlegada();
            }
            int tiempoEspera = tiempoActual - p.getTiempoLlegada();
            int tiempoRetorno = tiempoEspera + p.getRafagaCPU();

            tiempoActual += p.getRafagaCPU();

            resultados.add(new Resultado(p.getTrabajo(), Math.max(tiempoEspera, 0), tiempoRetorno, p.getTiempoLlegada()));
        }

        return resultados;
    }
}
