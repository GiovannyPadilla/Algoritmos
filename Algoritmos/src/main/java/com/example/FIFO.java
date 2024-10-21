package com.example;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
    public static List<Resultado> ejecutar(List<Proceso> procesos) {
        List<Resultado> resultados = new ArrayList<>();
        int tiempoActual = 0;

        for (Proceso p : procesos) {
            // Calcular tiempo de espera
            int tiempoEspera = tiempoActual - p.getTiempoLlegada();
            // Calcular tiempo de retorno
            int tiempoRetorno = tiempoEspera + p.getRafagaCPU();

            // Actualizar tiempo actual
            tiempoActual += p.getRafagaCPU();

            resultados.add(new Resultado(p.getTrabajo(), Math.max(tiempoEspera, 0), tiempoRetorno, p.getTiempoLlegada()));
        }

        return resultados;
    }
}
