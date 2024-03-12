﻿namespace AppConHilos2;

class Program
{
    static void Main(string[] args)
    {
        //Obtenemos el hilo actual e imprimimos algunas propiedades
        Thread currentThread = Thread.CurrentThread;
        currentThread.Name = "Hilo principal";

        //Establecemos su prioridad
        currentThread.Priority = ThreadPriority.Lowest;
        
        //Establecemos si corre en segundo plano o no
        currentThread.IsBackground = false;

        //Imprimimos sus propiedades
        Console.WriteLine("Thread Id: {0}", currentThread.ManagedThreadId);
        Console.WriteLine("Thread Name: {0}", currentThread.Name);
        Console.WriteLine("Thread State: {0}", currentThread.ThreadState);
        Console.WriteLine("Es un thread background: {0}", currentThread.IsBackground);
        Console.WriteLine("Priority: {0}", currentThread.Priority);
        Console.WriteLine("Culture: {0}", currentThread.CurrentCulture.Name);
        Console.WriteLine("UI Culture: {0}", currentThread.CurrentUICulture.Name);
        Console.WriteLine();

        //Cree un hilo secundario pasando un delegado ParameterizedThreadStart
        Thread workerThread = new Thread(new ParameterizedThreadStart(Print));

        //Le colocamos nombre al hilo
        workerThread.Name = "Hilo de Print";

        //Crear el token source.
        CancellationTokenSource cts = new CancellationTokenSource();

        //Iniciar hilo secundario, ahora le enviamos un token
        workerThread.Start(cts.Token);

        //Hilo principal: Imprime de 1 a 10 cada 0,2 segundos.
        //El método Thread.Sleep es responsable de hacer que el hilo actual entre en suspensión
        //en milisegundos. Mientras duerme, un hilo no hace nada.
        for (int i = 0; i < 10; i++)
        {
            Console.WriteLine($"Principal thread: {i}");
            Thread.Sleep(200);
        }

        //Si el hilo sigue ejecutándose, lo cancelamos
        if (workerThread.IsAlive)
            cts.Cancel();
    }

    static void Print(object? obj)
    {
        //Se debe asegurar que el token viene como parámetro
        if (obj == null)
            return;

        //Recibimos el token
        CancellationToken token = (CancellationToken)obj;

        //Obtenemos el hilo actual e imprimimos algunas propiedades
        Thread currentThread = Thread.CurrentThread;

        //Establecemos su prioridad
        currentThread.Priority = ThreadPriority.Highest;

        //Establecemos si corre en segundo plano o no
        currentThread.IsBackground = false;

        //Imprimimos sus propiedades
        Console.WriteLine("Thread Id: {0}", currentThread.ManagedThreadId);
        Console.WriteLine("Thread Name: {0}", currentThread.Name);
        Console.WriteLine("Thread State: {0}", currentThread.ThreadState);
        Console.WriteLine("Es un thread background: {0}", currentThread.IsBackground);
        Console.WriteLine("Priority: {0}", currentThread.Priority);
        Console.WriteLine("Culture: {0}", currentThread.CurrentCulture.Name);
        Console.WriteLine("UI Culture: {0}", currentThread.CurrentUICulture.Name);
        Console.WriteLine();

        for (int i = 11; i < 20; i++)
        {
            if (token.IsCancellationRequested)
            {
                Console.WriteLine("En la iteración {0}, la cancelación ha sido solicitada...", i);
                //Termina la operación for
                break;
            }

            Console.WriteLine($"Print thread: {i}");
            Thread.Sleep(1000);
        }
    }
}
