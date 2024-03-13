package org.practicatrim2


import com.github.ajalt.mordant.rendering.TextColors.*
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

class Pelea(val jugador:Jugador, val npc: Enemigo) {
    var distancia = Random.nextInt(1, 10)

    fun mostrarcositas(){
        GestionConsola.funcionamientoJuego()
        GestionConsola.mostrarinfo("\n \n")// para darle espacio entre una pregunta y otra
        GestionConsola.funcionamientoArmas()
        clearConsole()
    }

    fun iniciarPelea(jugador: Jugador, npc:Enemigo, pelea: Pelea, atacable: Atacable) {

        var dañoRecibido = jugador.arma.danio // siempre recibe daño aunque no ataquen


        GestionConsola.mostrarinfo("Que comience el duelo!")
        GestionConsola.mostrarinfo("Te enfrentas contra ${npc.nombre}, la distancia actual es: $distancia metros")



        while (jugador.estavivo() && npc.estavivo()) {

            GestionConsola.opcionesPelea(jugador, npc, atacable, pelea)


            //turno del Jugador
            GestionConsola.mostrarinfo("Tu arma es😈 ${jugador.arma.javaClass.simpleName}")
            GestionConsola.mostrarinfo("${jugador.nombre} Que quieres hacer?")
            GestionConsola.mostrarAtacarHuir(jugador,npc, pelea, atacable)
            npc.recibirDaño(dañoRecibido)
            //comprueba si esta vivo el enemigo y si no es asi, muestra mensaje de que esta muerto
            if (!npc.estavivo()) {
                GestionConsola.mostrarinfo("${npc.nombre} Ha muerto")
            } else {

                clearConsole()
                //turno de la máquina
                GestionConsola.mostrarinfo("Tu arma es😎 ${npc.arma.javaClass.simpleName}")
                GestionConsola.mostrarinfo("${npc.nombre} Que quieres hacer?")
                GestionConsola.mostrarAtacarHuir(jugador, npc, pelea, atacable)
                jugador.recibirDaño(dañoRecibido)

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


