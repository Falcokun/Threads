# Threads
##Programacion Java
2015-I

###Concurrencia
1) Variables Atomicas<br>
2) Lock<br>
3) Sincronizados<br>
4) Concurrency Collections Framework<br>

###Variables Atomicas
######a)Scalar Atomic Variables
AtomicInteger / AtomicLong / AtomicBoolean
######b) Atomic Array Classes
AtomicIntegerArray / AtomicLongArray / AtomicReferenceArray
######c) Atomic Field Updater Classes
AtomicFieldUpdate... y etc
######d) Atomic Compound Variable Classes
AtomicMarkeableReference
AtomicStampedReference

###Synchronizers

#####Phaser
La diferencia con las barreras es que el phaser se pueden agregar o remover participantes en cualquier punto
Los Phaser tiene un numero de fases que inicia en 0, cuando llega el participante, se aumenta en 1. 
Cuando llegan a la barrier, todos pasan a la siguiente etapa.
#####Latcher
Similares a las barreras, detiene algo hasta que se cumpla una condicion dada
#####Exchangers
Permite cambiar un elemento entre 2 hilos

###Frameworks
java.time 80clases
JDK 8 -> Separa el tiempo Machine y Human
<br>
Legacy Api vs New Api (Java 8)
######Machine -> "Duracion"
######Humano -> "Periodo"
<br>
####Problemas old API: 
<br>
No se podia separar fecha de la hora
<br>
Medido como un numero que media milisegundos transcurridos desde 1 enero 1970
<br>
Manipulacion de los datos era dificil, porque la manipulacion de años era desde 1970 y los meses de 0-11
<br>
Las clases de la API Legacy son mutables, es decir, no manejan concurrencia, no son ThreadSafe
<br>
Maneja calendario Juliano y Gregoriano
<br><br><br>
#####Nueva API 
Maneja ISO-8161, ademas de Juliano y Gregoriano | Estandar de manejo de horas a nivel mundial
<br>
4 subpaquetes -> 80 clases
<br>
Chrono, Format, Temporal y Zone
<br>

#####Punto de Referencia (New API)
######Maquina
Instante: Linea de tiempo ->  un momento es un instante.
<br>
Duracion: transcurso entre dos instantes -> medida en nanosegundos
<br>
Instant, Duration
######Humano
[Fecha] [Hora] [offset]
<br>
LocalDate, LocalTime, LocalDateTime, OffsetTime, OffsetDateTime, ZoneDateTime, ZoneOffset, ZoneID