package org.practicatrim2


import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

class Pelea(val jugador:Jugador, val npc: Jugador) {
    var distancia = Random.nextInt(1,10)


    fun iniciarPelea(jugador: Jugador, npc: Jugador, pelea: Pelea, atacable: Atacable){



        var dañoRecibido = jugador.arma.danio // siempre recibe daño aunque no ataquen

        GestionConsola.mostrarinfo("Que comience el duelo!")
        println("trozo historia inicial... te encuentras con un borracho bla bla bla...")

        while (jugador.estavivo() && npc.estavivo()){



            println("Tu arma es😈 ${pelea.jugador.arma.javaClass.simpleName}")
            println("${jugador.nombre} Que quieres hacer?")
            GestionConsola.mostrarAtacarHuir(jugador, npc,pelea, atacable)
            npc.recibirDaño(dañoRecibido)
            if (!npc.estavivo())



            clearConsole()

            println("Tu arma es😎 ${pelea.npc.arma.javaClass.simpleName}")
            println("${npc.nombre} Que quieres hacer?")
            GestionConsola.mostrarAtacarHuir(jugador, npc, pelea, atacable)
            jugador.recibirDaño(dañoRecibido)
            if (!jugador.estavivo())

            clearConsole()
            //Para el bucle pero cuando acaba todoo y comprueba de nuevo si estan vivos
        }
    }
    fun clearConsole() {
        println("\n---------------------------------------------------------------------------------------------------------------------\n")
    }
}
