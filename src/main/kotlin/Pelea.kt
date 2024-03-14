package org.practicatrim2


import com.github.ajalt.mordant.rendering.TextColors.*
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

class Pelea(val jugador:Jugador, val npc: Enemigo) {
    var distancia = Random.nextInt(1, 10)

    fun mostrarcositas(pelea:Pelea, atacable: Atacable){
        GestionConsola.funcionamientoJuego()
        GestionConsola.mostrarinfo("\n \n")// para darle espacio entre una pregunta y otra
        GestionConsola.funcionamientoArmas()
        clearConsole()
        GestionConsola.historia1()
        clearConsole()
        GestionConsola.mostrarinfo("Te enfrentas contra ${npc.nombre}, la distancia actual es: $distancia metros")
        GestionConsola.mostrarAtacarHuir(jugador,npc, pelea, atacable)
    }

    fun iniciarPelea(jugador: Jugador, npc:Enemigo, pelea: Pelea, atacable: Atacable) {


        GestionConsola.mostrarinfo("Que comience el duelo!")

        while (jugador.estavivo() && npc.estavivo()) {
            //turno del Jugador
            GestionConsola.mostrarinfo("${jugador.nombre} Tu arma es😈 ${jugador.arma.javaClass.simpleName}. Que quieres hacer?")
            GestionConsola.opcionesPelea(jugador, npc, atacable, pelea)

            //comprueba si esta vivo el enemigo y si no es asi, muestra mensaje de que esta muerto
            if (!npc.estavivo()) {
                GestionConsola.mostrarinfo("${npc.nombre} Ha muerto")
            } else {

                clearConsole()
                //turno de la máquina
                GestionConsola.mostrarinfo("${npc.nombre} Tu arma es😎 ${npc.arma.javaClass.simpleName}. Que quieres hacer?")
                GestionConsola.opcionesPeleaNpc(jugador, npc, atacable, pelea)

                //comprueba si el jugador esta vivo, si no muestra un mensaje de muerte
                if (!jugador.estavivo()) {
                    GestionConsola.mostrarinfo("${jugador.nombre} Ha muerto")
                }else{
                    clearConsole()
                }

            }


        }
    }

    fun clearConsole() {
        GestionConsola.mostrarinfo("\n---------------------------------------------------------------------------------------------------------------------\n", brightMagenta)
    }
}


