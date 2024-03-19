import java.util.Random;

public class Filosofo implements Runnable {
    private String nombre;
    private Random random = new Random();
    private int tenedorIzquierdo;
    private int tenedorDerecho;
    private Integer[] tenedores;
    private Object lock;

    public Filosofo(String nombre, int tenedorIzquierdo, int tenedorDerecho, Integer[] tenedores, Object lock) {
        this.nombre = nombre;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
        this.tenedores = tenedores;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(nombre + " preparándose para comer");
            TomarTenedor();
            Comer();
            Pensar();
        }
    }

    public void Pensar() {
        int time = random.nextInt(10000 - 1000 + 1) + 1000;
        System.out.println(nombre + " está pensando");

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void TomarTenedor() {
        int time = random.nextInt(10000 - 1000 + 1) + 1000;

        synchronized (lock) {
            while (tenedores[tenedorIzquierdo] == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
            System.out.println(nombre + " toma su tenedor izquierdo " + "tenedor" + tenedorIzquierdo);
            tenedores[tenedorIzquierdo] = 0;
        }
    
        synchronized (lock) {
            while (tenedores[tenedorDerecho] == 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    
            System.out.println(nombre + " toma su tenedor derecho " + "tenedor" + tenedorDerecho);
            tenedores[tenedorDerecho] = 0;
        }
    
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    

    public void Comer() {
        if (tenedores[tenedorIzquierdo] == 0 && tenedores[tenedorDerecho] == 0) {
            int time = random.nextInt(10000 - 1000 + 1) + 1000;
            System.out.println(nombre + " está comiendo");

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                tenedores[tenedorIzquierdo] = 1;
                tenedores[tenedorDerecho] = 1;
                lock.notifyAll();
            }
        }
    }
}
