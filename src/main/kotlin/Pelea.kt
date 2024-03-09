package org.practicatrim2

class Pelea(val jugador:Jugador, val distancia:Int) {
    //la distancia es un random que se pone a principio de la pelea o que puede ir aumentando segun me de tiempo o no


    fun mostrarAtacarHuir(opcionARealizar:Int){
        println("1. Pelear")
        println("2.Lo insultas y pasas de el")
        println("3. Coges por otra calle")


        when (opcionARealizar){
            1 -> pelear()
            2 -> insultar()
            3 -> cogerOtraCalle()
        }
    }
    fun pelear(){


    }


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


    fun controlPelea(jugador1: Jugador, npc: Jugador){
        val pinguino = true
        while (pinguino){
            println("${jugador1.nombre} Que quieres hacer?")


        }
    }
}
