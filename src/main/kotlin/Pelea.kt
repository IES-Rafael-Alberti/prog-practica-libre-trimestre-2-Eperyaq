package org.practicatrim2


import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

class Pelea(val jugador:Jugador, val npc: Jugador) {
    var distancia = Random.nextInt(1,10)


    fun iniciarPelea(jugador: Jugador, npc: Jugador, pelea: Pelea, atacable: Atacable){
        val pinguino = true
        println("Que comience el duelo!")

        while (pinguino){

            println("trozo historia inicial... te encuentras con un borracho bla bla bla...")

            println(pelea.jugador.arma.javaClass.simpleName)
            println("${jugador.nombre} Que quieres hacer?")
            GestionConsola.mostrarAtacarHuir(jugador, npc,pelea, atacable)
            npc.morir()

            clearConsole()

            println("${npc.nombre} Que quieres hacer?")
            GestionConsola.mostrarAtacarHuir(jugador, npc, pelea, atacable)
            jugador.morir()


        }
    }
    fun clearConsole() {
        println("---------------------------------------------------------------------------------------------------------------------")
    }
}
