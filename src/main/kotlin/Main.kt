package org.practicatrim2
import org.practicatrim2.Armas.*

fun main() {

    val listaArmasDCS  = listOf(
        Escopeta(5,2),
        EscopetaLargaDistancia(5,5),
        Revolver(12,6),
        Cuchillo(5)
    ).random()

    val listaEnemigos = listOf(
        Enemigo("Jorge El Feo",listaArmasDCS,7),
        Enemigo("David El Mataescorias",listaArmasDCS,10),
        Enemigo("Viti El Loco",listaArmasDCS,15)
    ).random()

    val personajePrincipal = Jugador("Elia",listaArmasDCS,10)

    val pelea = Pelea(personajePrincipal,listaEnemigos)


    pelea.mostrarcositas(pelea,listaArmasDCS)





}