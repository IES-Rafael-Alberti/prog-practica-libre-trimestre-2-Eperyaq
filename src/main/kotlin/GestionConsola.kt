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

    fun opcionesPelea(jugador: Jugador, ) {
        println("1. Disparar")
        println("2. Curarse")
        println("3. Recargar")
        println("4. Huir")

        val opcion = preguntarnum()

        when (opcion){
            1->
        }


    }



    fun dado(){
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