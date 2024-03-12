package org.practicatrim2
import com.github.ajalt.mordant.terminal.Terminal
import org.practicatrim2.Armas.*

fun main() {

    val listaArmasDCS  = listOf(
        Escopeta(5,2),
        EscopetaLargaDistancia(5,5),
        Revolver(12,6),
        Cuchillo(5)
    ).random()

    //val dado = GestionConsola.dado() // funciona guay

    val personajePrincipal = Jugador("Khenji",listaArmasDCS,10)
    val j1 = Jugador("Elia",listaArmasDCS,1)
    val pelea = Pelea(personajePrincipal,j1)

    pelea.iniciarPelea(personajePrincipal,j1,pelea, listaArmasDCS)
    val t = Terminal()

}