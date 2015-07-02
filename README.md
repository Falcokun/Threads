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