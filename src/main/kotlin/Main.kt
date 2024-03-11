package org.practicatrim2
import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.Escopeta
import org.practicatrim2.Armas.TipoArma

fun main() {
    /*
    val dado = GestionConsola.dado() // funciona guay

    val personajePrincipal = Jugador("Khenji",TipoArma.Escopeta,10)
    println("Vas andando por el antiguo oeste en busqueda de la ubicacion que te venia en la carta que recogiste")
    println("Te encuentras con un borracho que te reta a un duelo")
    GestionConsola.mostrarAtacarHuir(personajePrincipal)

     */

    val listaArmas = listOf(
        TipoArma.EscopetaLargaDistancia,
        TipoArma.Escopeta, TipoArma.Cuchillo, TipoArma.Revolver, TipoArma.palo_GomaEspuma).random()
    val j1 = Jugador("Elia",listaArmas,5)
    j1.info()

    // todo Poner en las armas, si no tienes suficiente municion preguntarle que hacer

    fun obtenerArmaRandom(escopeta:Escopeta):Atacable{
        val armas:List = (Escopeta(TipoArma.Escopeta,"12mm",5,2))
    }
}