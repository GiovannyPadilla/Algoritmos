package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Proceso> procesosFIFO = new ArrayList<>(Arrays.asList(
                new Proceso("A", 3, 2),
                new Proceso("B", 1, 4),
                new Proceso("C", 3, 0),
                new Proceso("D", 4, 1),
                new Proceso("E", 2, 3)
        ));

        System.out.println("Ejecutando FIFO:");
        ejecutarYMostrarResultados("FIFO", procesosFIFO);

        System.out.println("\nEjecutando SJF:");
        List<Proceso> procesosSJF = new ArrayList<>(Arrays.asList(
                new Proceso("A", 3, 2),
                new Proceso("B", 1, 4),
                new Proceso("C", 3, 0),
                new Proceso("D", 4, 1),
                new Proceso("E", 2, 3)
        ));
        ejecutarYMostrarResultados("SJF", procesosSJF);

        System.out.println("\nEjecutando Prioridad:");
        List<Proceso> procesosPrioridad = new ArrayList<>(Arrays.asList(
                new Proceso("A", 3, 2, 2),
                new Proceso("B", 1, 4, 3),
                new Proceso("C", 3, 0, 1),
                new Proceso("D", 4, 1, 3),
                new Proceso("E", 2, 3, 4)
        ));
        ejecutarYMostrarResultados("Prioridad", procesosPrioridad);

        System.out.println("\nEjecutando Round Robin:");
        List<Proceso> procesosRR = new ArrayList<>(Arrays.asList(
                new Proceso("A", 3, 2, 2),
                new Proceso("B", 1, 4, 3),
                new Proceso("C", 3, 0, 1),
                new Proceso("D", 4, 1, 3),
                new Proceso("E", 2, 3, 4)
        ));
        int quantum = 2; // Cambia el quantum según sea necesario
        ejecutarYMostrarResultados("Round Robin", procesosRR, quantum);
    }

    private static void ejecutarYMostrarResultados(String algoritmo, List<Proceso> procesos) {
        List<Resultado> resultados;
        switch (algoritmo) {
            case "FIFO":
                resultados = FIFO.ejecutar(procesos);
                break;
            case "SJF":
                resultados = SJF.ejecutar(procesos);
                break;
            case "Prioridad":
                resultados = Prioridad.ejecutar(procesos);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo desconocido: " + algoritmo);
        }
        imprimirTabla(resultados);
    }

    private static void ejecutarYMostrarResultados(String algoritmo, List<Proceso> procesos, int quantum) {

        List<Resultado> resultados = RoundRobin.ejecutar(procesos, quantum);
        imprimirTabla(resultados);
    }

    // Método para imprimir resultados en formato tabla
    private static void imprimirTabla(List<Resultado> resultados) {
        System.out.printf("%-10s %-15s %-15s %-15s\n", "Proceso", "Tiempo de Espera", "Tiempo de Retorno", "Tiempo de Llegada");
        System.out.println("---------------------------------------------------------");

        for (Resultado r : resultados) {
            System.out.printf("%-10s %-15d %-15d %-15d\n", r.getNombre(), r.getTiempoEspera(), r.getTiempoRetorno(), r.getTiempoLlegada());
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("Tiempo Medio de Espera = %.2f\n", resultados.stream().mapToDouble(Resultado::getTiempoEspera).average().orElse(0));
        System.out.printf("Tiempo Medio de Retorno = %.2f\n", resultados.stream().mapToDouble(Resultado::getTiempoRetorno).average().orElse(0));
    }
}
