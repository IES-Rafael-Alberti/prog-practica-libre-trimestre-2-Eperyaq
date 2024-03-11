package org.practicatrim2
import org.practicatrim2.Armas.*

fun main() {

    val dado = GestionConsola.dado() // funciona guay


/*
    val personajePrincipal = Jugador("Khenji",TipoArma.Escopeta,10)
    println("Vas andando por el antiguo oeste en busqueda de la ubicacion que te venia en la carta que recogiste")
    println("Te encuentras con un borracho que te reta a un duelo")
    GestionConsola.mostrarAtacarHuir(personajePrincipal)

     */

    val listaArmasDCS  = listOf(
        Escopeta(5,2),
        EscopetaLargaDistancia(5,5),
        Revolver(12,6),
        Cuchillo(5,5)
        ).random()

    val j1 = Jugador("Elia",listaArmasDCS,5)
    j1.info()



    // todo Poner en las armas, si no tienes suficiente municion preguntarle que hacer

   /* fun obtenerArmaRandom(escopeta:Escopeta):Atacable{
        val armas:List = (Escopeta(TipoArma.Escopeta,"12mm",5,2))
    }

    */
}