package org.practicatrim2

class Pelea(val jugador:Jugador, var distancia:Int) {

    fun opcionesPelea(){
        println("1. Disparar")
        println("2. Curarse")
        println("3. Huir")


    }

    fun pelear(){



    }

/*
    fun opciones(maxop:Int):Int{
        print("Escoge tu opcion: ")
        val opcion = 0
        var controlador = true

        while (controlador) {
            if (opcion > maxop) {
                throw Exception("Escoge un valor correcto")
            } else {
                controlador = false
                return opcion
            }
        }

    }

 */


    fun controlPelea(jugador1: Jugador, npc: Jugador){
        val pinguino = true
        while (pinguino){
            println("${jugador1.nombre} Que quieres hacer?")


        }
    }
}
