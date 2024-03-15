package Ejercicio2;

public class Hilo implements Runnable {
    private String cadena;

    public Hilo(String cadena) {
        this.cadena = cadena;
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(cadena + " ");

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
    
}
