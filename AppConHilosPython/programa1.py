import threading
import os

# Función para el hilo 1
def task1():
    print("Tarea 1 asignada al thread: {}".format(threading.current_thread().name))
    print("ID del proceso corriendo la tarea 1: {}".format(os.getpid()))

# Función para el hilo 2
def task2():
    print("Tarea 2 asignada al thread: {}".format(threading.current_thread().name))
    print("ID del proceso corriendo la tarea 2: {}".format(os.getpid()))

# Aunque ya sabemos que este es el programa principal,
# ejemplificamos el uso de la variable __name__
if __name__ == "__main__":
    print("ID del proceso corriendo el programa main: {}".format(os.getpid()))
    print("Nombre del Main thread: {}".format(threading.current_thread().name))

# Creamos los hilos
t1 = threading.Thread(target=task1, name="Hilo1")
t2 = threading.Thread(target=task2, name="Hilo2")

# Iniciamos los hilos
t1.start()
t2.start()

print("Programa terminado!")