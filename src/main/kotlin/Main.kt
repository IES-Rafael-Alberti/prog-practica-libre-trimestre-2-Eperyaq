package org.practicatrim2
import org.practicatrim2.Armas.*

//COSAS A TENER EN CUENTA AL JUGAR
/*
* Se que hay algunas armas que son un poco coñazo de usar como puede ser la escopeta que solo puedes pegar 2 tiros y despues te ves en la obligacion de recargar o el palo de goma espuma que es un poco troll
* Pero asi he decido que quiero que funcione el juego, que conste que esta hecho a posta
*
* Hay algunas funciones que no uso porque esta no quiero que sea la version final del juego, no me ha dado tiempo a implementarlas bien y para entregar algo que va a funcionar mal, no las uso y las arreglo
* Para implementarlos en otro momento
*
* Para instanciar un PersonajePrincipal o un Jugador (que es lo mismo) Tienes que hacerlo manualmente porque no me ha dado tiempo a hacer una funcion para crear un jugador que funcione de la manera que yo quiero
* */


fun main() {
    //Lista de armas, no te voy a quitar el merito, el dcs se queda
    val listaArmasDCS  = listOf(
        Escopeta(2,2),
        EscopetaLargaDistancia(5,5),
        Revolver(12,6),
        PalodeGomaEspuma(),
        Cuchillo(5)

    ).random()

    //Creacion de enemigos
    val npc1 = Enemigo("Jose El Cuñao",listaArmasDCS,4)
    val npc2 = Enemigo("Viti El Loco",listaArmasDCS,9)
    val npc3 = Enemigo("David El Mataescorias",listaArmasDCS,10)
    val npc4 = Enemigo("Pablo El VitruvianMan",listaArmasDCS,12)
    val npc5 = Enemigo("Pepe El Rancio",listaArmasDCS,7)

    //creacion de pila
    val pilaEnemigo = PilaEnemigo()

    //añadimos enemigos a la pila
    pilaEnemigo.push(npc1)
    pilaEnemigo.push(npc2)
    pilaEnemigo.push(npc3)
    pilaEnemigo.push(npc4)
    pilaEnemigo.push(npc5)

    //Sacamos enemigos de la pila para luchar contra ellos
    val enemigo1 = pilaEnemigo.pop()
    val enemigo2 = pilaEnemigo.pop()
    val bossFinal = Enemigo("Diego Cano", listaArmasDCS, 15)


    //creacion del pj
    val personajePrincipal = Jugador("Elia",listaArmasDCS,14)

    //creacion de la pelea pasandole por parametros los personajes con los que se va a pelear
    val pelea = Pelea(personajePrincipal,enemigo1,enemigo2, bossFinal)


    //Comienza el juego
    GestionConsola.mostrarcositas( personajePrincipal, enemigo1, pelea,listaArmasDCS)
    if (personajePrincipal.estavivo() && GestionConsola.preguntarSeguir()) { //Pregunta si quieres seguir jugando, si no quieres termina y si quieres te mete de nuevo a la pelea
        GestionConsola.mostrarcositas2(personajePrincipal, enemigo2, pelea, listaArmasDCS)

        if (personajePrincipal.estavivo() && GestionConsola.preguntarSeguir()) { // lo mismo pregunta si quieres seguir jugando, si no quieres termina y si quieres te mete de nuevo a la pelea
            GestionConsola.mostrarcositas3(personajePrincipal, bossFinal, pelea, listaArmasDCS)
            if (personajePrincipal.estavivo()){
                GestionConsola.finHistoria()
            }
        }
    }
}