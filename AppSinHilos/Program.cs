namespace AppSinHilos;

class Program
{
    public static void DoTrabajoPesado()
    {
        Console.WriteLine("DoTrabajoPesado: Estoy levantando un camión!!");
        Thread.Sleep(1000);
        Console.WriteLine("DoTrabajoPesado: Cansado! Necesito una siesta de 3seg.");
        Thread.Sleep(1000);
        Console.WriteLine("DoTrabajoPesado: 1...");
        Thread.Sleep(1000);
        Console.WriteLine("DoTrabajoPesado: 2...");
        Thread.Sleep(1000);
        Console.WriteLine("DoTrabajoPesado: 3...");
        Console.WriteLine("DoTrabajoPesado: Ya desperté");
    }

    public static void DoAlgo()
    {
        Console.WriteLine("DoAlgo: Oye! Haciendo algo aquí!");
        for (int i = 0; i < 20; i++)
            Console.Write($"{i} ");
        Console.WriteLine();
        Console.WriteLine("DoAlgo: Ya terminé.");
    }

    //Este es el punto de entrada de un programa C#
    static void Main(string[] args)
    {
        //La ejecución del programa inicia aquí
        Console.WriteLine("El Main thread comienza aquí.");
        Console.WriteLine("Nara: Desarrollo de sistemas en red");

        //Este método tarda 4 segundos en terminar.
        Program.DoTrabajoPesado();

        //Este método no se tarda nada.
        Program.DoAlgo();

        //La ejecución termina aquí.
        Console.WriteLine("El Main thread termina aquí.");
        Console.WriteLine("Presione cualquier tecla para terminar...");
        Console.ReadKey(true);
    }
}
