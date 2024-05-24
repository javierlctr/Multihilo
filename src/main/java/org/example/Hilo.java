package org.example;

import java.util.ArrayList;

public class Hilo extends Thread {
    private final int numeroHilo;
    private static volatile int posicion = 1;
    private ArrayList<Hilo> listadoHilos;

    public void setListadoHilos(ArrayList<Hilo> listadoHilos) {

        this.listadoHilos = listadoHilos;
    }

    public Hilo(int numeroHilo) {

        this.numeroHilo = numeroHilo;
    }

    @Override
    public void run() {
        while (true){
                try {
                     Thread.sleep(10);
                } catch (InterruptedException e) {
                    if (posicion == numeroHilo) {
                        System.out.println("Hola, soy el hilo " + numeroHilo);
                        ++posicion;

                        if (posicion <= listadoHilos.size()) {
                            listadoHilos.get(posicion - 1).interrupt();
                        }
                        break;
                    }
                }
            }
        }

    @Override
    public String toString() {
        return "Hilo número " + numeroHilo + " creado";
    }
}
