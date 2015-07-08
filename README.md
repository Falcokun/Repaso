# Repaso
Repaso Progra Java 2015-I

##1. El archivo (10 puntos)
El zip contiene data, 2 archivos -> coordenadas de la data  | La data
El de coordenadas es binario
El de data es Random Access
*Una preguna del examen final es el pin pon pun con synchronized | con semaforo | con lock | con latches | con barrier
| y las variantes posibles

##2. Plantear Teoria para marcar a-b-c 
Posiblemente: Un caso para modelarlo o programarlo.



##Repaso Teorico:
###Threads:
#####Multitasking vs MultiProcessing:
En multitasking tu ejecutas varios procesos a la vez, mientras que en multiprocessing implica procesamiento en paralelo,
que una tarea corre en varios procesos simultaneamente. Para esto la tarea se divida en subprocesos.<br>
En Multitasking las tareas entran al procesador, con tiempos de uso de procesador, pseudopalarerismo. El sistema operativo
usa un scheduler de procesos. Hay 2 tipos de Multitasking, el cooperativo en donde el proceso determina cuanto tiempo estara
en el CPU o en el procesador. 

###1)Variables Atomicas
Sincronizan una variable simple, se usan en lugar de variables primitivas, todos sus metodos son
synchronized : ThreadSafe
#####a)Scalar Atomic Variables
AtomicInteger // AtomicLong // AtomicBoolean
#####b)Atomic Array Classes
AtomicIntegerArray // AtomicLongArray // AtomicReferenceArray
#####c)Atomic Field Updater Classes
AtomicFieldUpdate... y etc
#####d)Atomic Compound Variable Classes
Atomic MarkeableReference // AtomicStampedReference

###2) Lock
###3) Sincronizadores
###4) Concurrency Collections Framework
