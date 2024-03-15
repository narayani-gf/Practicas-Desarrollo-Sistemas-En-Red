package Ejemplo2;

public class Corredor implements Runnable {
    
    private String avance;
    private long latencia;
    private char c;

    // Constructor de la clase. Recibe un caracter identificador
    // que va ir avanzando poco a poco
    public Corredor(char c) {
        this.avance = "";
        //random() regresa un número entre 0.1 y 1.0
        this.latencia = (long) (Math.random() * 100);
        this.c = c;
    }

    // Método de la interfaz Runnable
    @Override
    public void run() {
        // Va a avanzar 70 ciclos
        for (int i = 0; i < 70; i++) {
            avance = avance + c;
            System.out.println(avance);
            try {
                Thread.sleep(latencia);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        avance = avance + " termine !!!";
        System.out.println(avance);
    }
}
