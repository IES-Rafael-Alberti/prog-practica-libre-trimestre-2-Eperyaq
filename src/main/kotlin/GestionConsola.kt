package org.practicatrim2
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

object GestionConsola {
    fun preguntarnum():Int{
        var penguin = true
        var numero= 0

        while (penguin){
            try {
                numero = readln().toInt()
                penguin = false
            }catch (e: NumberFormatException){
                println("Inserte un numero válido")
            }
        }
        return numero
    }

    fun mostrarAtacarHuir(jugador: Jugador){
        var num = 0

        println("1. Pelear")
        println("2.Lo insultas y pasas de el")
        println("3. Coges por otra calle")

        num =preguntarnum()


        when (num) {
           // 1 -> jugador.pelear()
            2 -> jugador.insultar()
           // 3 -> jugador.cogerOtraCalle()
        }

    }

    fun opcionesPelea(jugador: Jugador, atacable: Atacable, pelea: Pelea ) {
        println("1. Disparar")
        println("2. Curarse")
        println("3. Recargar")
        println("4. Huir")

        val opcion = preguntarnum()


        when (opcion){
            1-> jugador.arma.disparar(jugador, atacable.danio, pelea) // danio esta bien?
            2-> jugador.curarse()
            3-> jugador.arma.recargar()
            4->

        }



    }

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

    fun dado(){ //todo si meto una letra o un numero fuera del rango no lo controla
        println("Introduzca un numero entre 1-5")

        var numjugador = 0
        numjugador = preguntarnum()
        var numerodado = Random.nextInt(1,6) //genera un numero aleatorio entre el 1 y el 5
        try {

            if (numjugador == numerodado){
                println("Has tenido suerte")
            }else{
                println("No has acertado.")
            }
        }catch (e: NumberFormatException){
            println("ERROR, Pierdes la oportunidad por gracioso")
        }
    }

}