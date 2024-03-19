public class Comedor {
    public static void main(String[] args) {
        Integer[] tenedores = new Integer[5];

        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = 1;
        }

        Object lock = new Object();

        Thread F1 = new Thread(new Filosofo("Filosofo 1", 0, 1, tenedores, lock));
        Thread F2 = new Thread(new Filosofo("Filosofo 2", 1, 2, tenedores, lock));
        Thread F3 = new Thread(new Filosofo("Filosofo 3", 2, 3, tenedores, lock));
        Thread F4 = new Thread(new Filosofo("Filosofo 4", 3, 4, tenedores, lock));
        Thread F5 = new Thread(new Filosofo("Filosofo 5", 0,4, tenedores, lock));

        F1.start();
        F2.start();
        F3.start();
        F4.start();
        F5.start();
    }
}