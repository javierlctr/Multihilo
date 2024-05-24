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
                try {
                     Thread.sleep(1000);
                } catch (InterruptedException e) {
                    
                        System.out.println("Hola, soy el hilo " + numeroHilo);

                        if (numeroHilo < listadoHilos.size()) {
                            listadoHilos.get(numeroHilo).interrupt();
                        }
                    }
        }

    @Override
    public String toString() {
        return "Hilo número " + numeroHilo + " creado";
    }
}
