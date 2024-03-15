package Ejemplo2;

public class Programa2 {
    
    public static void main(String[] args) throws InterruptedException {
        // Se crean los corredores y se les asigna un identificador
        Corredor corredor1 = new Corredor('1');
        Corredor corredor2 = new Corredor('2');
        Corredor corredor3 = new Corredor('3');

        // Se ejecuta cada uno de los corredores en un hilo
        Thread p1 = new Thread(corredor1);
        Thread p2 = new Thread(corredor2);
        Thread p3 = new Thread(corredor3);

        // p1.start();
        // p2.start();
        // p3.start();

        p1.start();
        p1.join();
        p2.start();
        p2.join();
        p3.start();
        p3.join();
    }
}
