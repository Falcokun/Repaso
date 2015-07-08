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
ExplicitLock -> Lock y ReentrantLock<br>
Lock es la interfaz mas bascia y ReentranLock es una clase basica que implementa Lock<.
Solo un hilo puede poseer el lock al mismo tiempo, para acceder al recurso compartido, se requeire poseer el lock.
<br>
ReentrantLock es una clase.<br>
USO: Lock and Unlock -> no puede hacerle lock y el codigo esta esperando que haya unlock para continuar.
<br>
DeadLock | Abrazo de la muerte
###3) Sincronizadores
#####Barriers
Esperan que todos lleguen a la barrera y continua el codigo, una sola etapa
#####Phaser
La diferencia con las barreras es que el phaser se pueden agregar o remover participantes en cualquier punto
Los Phaser tiene un numero de fases que inicia en 0, cuando llega el participante, se aumenta en 1. 
Cuando llegan a la barrier, todos pasan a la siguiente etapa.
<br>
Tiene Fases. 
#####Semaforos
#####Latcher
Similares a las barreras, detiene algo hasta que se cumpla una condicion dada.
#####Exchangers
Permite cambiar un elemento entre 2 hilos-
#####Frameworks
######Executors
Lo de la alarma

######Joins
java.time 80clases
JDK 8 -> Separa el tiempo Machine y Human
<br>
Legacy Api vs New Api (Java 8)


###4) Concurrency Collections Framework
