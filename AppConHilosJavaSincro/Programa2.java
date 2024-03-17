public class Programa2 {
    private static Object hora = new Object();

    // clase privada que implementa Runnable
    private static class JuntaThread implements Runnable {
        public JuntaThread() {
            hora = 9;
        }

        @Override
        public void run() {
            realizarJunta();
        }

        // Método que imprime el inicio y fin de una junta
        public static void realizarJunta() {
            synchronized (hora) {
                System.out.println(Thread.currentThread().getName() + " junta iniciada a las " + hora);
                hora = (int) hora + 1;
                System.out.println(Thread.currentThread().getName() + " junta terminada a las " + hora);
            }
        }
    }

    public static void main(String[] args) {
        // Creamos 10 hilos, 1 para cada junta
        for (int i = 0; i < 10; i++) {
            Thread hilo1 = new Thread(new JuntaThread(), "Junta-" + (i + 1));
            hilo1.start();
        }
    }
}
