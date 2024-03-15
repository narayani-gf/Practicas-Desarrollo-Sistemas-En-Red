package Ejercicio2;

public class Programa2 {

    public static void main(String[] args) throws InterruptedException{
        Hilo hiloHola = new Hilo("Hola");
        Hilo hiloMundo = new Hilo("Mundo");

        Thread hola = new Thread(hiloHola);
        Thread mundo = new Thread(hiloMundo);

        hola.start();
        mundo.start();
    }
    
}
