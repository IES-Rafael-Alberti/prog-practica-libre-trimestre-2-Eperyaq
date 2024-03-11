package org.practicatrim2

class Pelea(val jugador:Jugador, var distancia:Int) {


    /**
     * Solicita al usuario introducir una opcion entre un rango especifico
     *
     * @param maxop Numero maximo de opciones que va a tener disponibles
     * @throws IllegalArgumentException Si el numero introducido por consola es mayor que [maxop] o igual que 0
     * @return opcion La opcion escogida
     */
    fun opciones(maxop:Int):Int{
        print("Escoge tu opcion: ")
        var opcion = GestionConsola.preguntarnum()
        var pinguinito = true

        while (pinguinito) {
            try {

                if (opcion > maxop || opcion ==0) {
                    throw IllegalArgumentException("Escoge un valor correcto") // si indican un numero mayor al pasado por parametros da error
                } else {
                    pinguinito = false
                }


            } catch (e: IllegalArgumentException) {
                println("ERROR, escoge un valor correcto")
                opcion = GestionConsola.preguntarnum()
            }
        }
            return opcion
    }



    fun controlPelea(jugador1: Jugador, npc: Jugador){
        val pinguino = true
        while (pinguino){
            println("${jugador1.nombre} Que quieres hacer?")


        }
    }
}
