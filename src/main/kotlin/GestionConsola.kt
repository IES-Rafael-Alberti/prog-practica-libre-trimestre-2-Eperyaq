package org.practicatrim2
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

object GestionConsola {

    /**
     * Solicita al usuario introducir un numero a traves de la consola
     *
     * Hasta que no introduce un numero correcto no va a parar de preguntar por ese numero
     *
     * @return El numero introducido por el usuario
     */
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

    fun mostrarAtacarHuir(jugador: Jugador, npc:Jugador, pelea: Pelea, atacable: Atacable){
        var num = 0

        println("1. Pelear")
        println("2.Lo insultas y pasas de el")

        num = opciones(2)

        when (num) {
            1 -> opcionesPelea(jugador, atacable,pelea)
            2 -> jugador.insultar()
        }
    }

    fun opcionesPelea(jugador: Jugador, atacable: Atacable, pelea: Pelea ) {
        println("1. Disparar")
        println("2. Curarse")
        println("3. Recargar")
        println("4. Huir")

        val opcion = opciones(4)
        when (opcion){
            1-> if (jugador.arma.comprobarMuncion()) {
                    jugador.arma.disparar(jugador, pelea, atacable)
                }else{
                    opcionesPelea(jugador,atacable,pelea)
                }
            2-> jugador.curarse()
            3-> jugador.arma.recargar()
            4-> jugador.huir()
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
        var opcion =preguntarnum()
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
                opcion = preguntarnum()
            }
        }
        return opcion
    }

    /**
     * Tiras un dado
     *
     * @return true Si has tenido suerte y has acertado el numero del dado.
     * false Si no has tenido suerte y no has acertado el numero del dado.
     *
     */
    fun dado():Boolean{
        println("Introduzca un numero entre 1-5")

        var numjugador = 0
        numjugador = opciones(5)
        var numerodado = Random.nextInt(1,6) //genera un numero aleatorio entre el 1 y el 5

        if (numjugador == numerodado){
            println("Has tenido suerte")
            return true
        }else{
            println("No has acertado.")
            return false
        }
    }

    fun mostrarinfo(mensaje:String){// pasar por parametro el mensaje y listo
        println(mensaje)
    }
}