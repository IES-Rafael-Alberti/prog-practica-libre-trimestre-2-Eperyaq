package org.practicatrim2
import kotlin.random.Random

fun main() {
    //val dado = GestionConsola.dado() // funciona guay
    val j1 = Jugador("Elia",TipoArma.EscopetaLargaDistancia,5)
     val opciones = Pelea(j1, 10)
    opciones.opciones(3)
}