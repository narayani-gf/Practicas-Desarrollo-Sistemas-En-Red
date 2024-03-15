package Ejercicio1;

public class Hilo implements Runnable{
    private String name;
    private int inicio;
    private int fin;

    public Hilo (String name, int inicio, int fin) {
        this.name = name;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        if (inicio < fin){
            for (int i = inicio; i < fin+1; i++) {
                System.out.println(name + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else{
            for (int i = inicio; i > fin-1; i--) {
                System.out.println(name + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }   
            }
        }
        
    }    
}
