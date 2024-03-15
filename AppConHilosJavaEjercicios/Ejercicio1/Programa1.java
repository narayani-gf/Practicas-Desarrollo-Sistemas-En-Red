package Ejercicio1;

public class Programa1 {

    public static void main (String[] args) throws InterruptedException{
        Hilo hilo1 = new Hilo("Hilo1", 1, 100);
        Hilo hilo2 = new Hilo("Hilo2", 100, 1);

        Thread h1 = new Thread(hilo1);
        Thread h2 = new Thread(hilo2);

        h1.start();
        h2.start();
    }
    
}
