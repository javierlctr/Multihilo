package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Introduce el número de hilos que quieres ejecutar: ");
        //CREAR OBJETO SCANNER
        Scanner scanner = new Scanner(System.in);
        int numeroHilos = scanner.nextInt();

        //CREAR ARRAYLIST TIPO THREAD PARA PODER ACCEDER AL METODO START() DE CADA HILO
        ArrayList<Hilo> hilos = new ArrayList<>();

        //CREAR Y AÑADIR HILOS AL ARRAYLIST
        for (int i=0; i < numeroHilos; i++) {
            Hilo hilo = new Hilo(i +1);
            hilos.add(hilo);
        };

        //PASAR ARRAYLIST A CADA HILO
        for (Hilo hilo : hilos) {
            hilo.setListadoHilos(hilos);
        }

        //EJECUTAR HILOS A LA VEZ
        for (Hilo hilo : hilos) {
            hilo.start();
        }

        if (!hilos.isEmpty()) {
            hilos.get(0).interrupt();
        }
    }
}