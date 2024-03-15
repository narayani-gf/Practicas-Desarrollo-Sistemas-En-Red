/*
public class Programa1 implements Runnable {

    //Este método de la clase Runnable debe ser implementado
    //Se ejecuta al llamar el método start()
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " subproceso corriendo...");
    }

    public static void main (String[] args) {
        //Ejemplo de como se crea un hilo en Java
        Thread hilo = new Thread(new Programa1(), "Hilo1");
        hilo.start();
        System.out.println("Este codigo esta fuera del hilo");
    }
}
*/

public class Programa1 extends Thread {

    //Esste método es de la clase Thread
    //Se ejecuta al llamar el método start()
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " subproceso corriendo...");
    }

    public static void main (String[] args) {
        //Ejemplo de como se crea un hilo en Java
        Programa1 hilo = new Programa1();
        hilo.start();
        System.out.println("Este codigo esta fuera del hilo");
    }
}