package org.practicatrim2
import org.practicatrim2.Armas.*

fun main() {

    val listaArmasDCS  = listOf(
        Escopeta(5,2),
        EscopetaLargaDistancia(5,5),
        Revolver(12,6),
        Cuchillo(5)
    ).random()

    //val dado = GestionConsola.dado() // funciona guay
 /*

    println("Vas andando por el antiguo oeste en busqueda de la ubicacion que te venia en la carta que recogiste")
    println("Te encuentras con un borracho que te reta a un duelo")
    GestionConsola.mostrarAtacarHuir(personajePrincipal)


  */
    val personajePrincipal = Jugador("Khenji",listaArmasDCS,10)
    val j1 = Jugador("Elia",listaArmasDCS,5)
    val pelea = Pelea(personajePrincipal,j1)

    pelea.iniciarPelea(personajePrincipal,j1,pelea, listaArmasDCS)


}