package org.practicatrim2
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.terminal.Terminal
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

object GestionConsola {

    val terminal = Terminal() // para mordam

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

    fun mostrarAtacarHuir(jugador: Jugador,npc: Enemigo, pelea: Pelea, atacable: Atacable){
        var num = 0

        mostrarinfo("1.Pelear")
        mostrarinfo("Un verdadero hombre, cuando es faltado al respeto lo unico que quiere es SANGRE!", TextColors.red)
        num = opciones(1)

        when (num) {
            1 -> pelea.iniciarPelea(jugador, npc, pelea, atacable)
        }
    }

    fun opcionesPelea(jugador: Jugador, npc:Enemigo, atacable: Atacable, pelea: Pelea ) {
        mostrarinfo("1. Disparar")
        mostrarinfo("2. Pegar a Melee")
        mostrarinfo("3. Curarse")
        mostrarinfo("4. Recargar")
        mostrarinfo("5. Acercarte")
        mostrarinfo("6. Huir")

        val opcion = opciones(6)
        when (opcion){
            1-> if (jugador.arma.comprobarMuncion()) {
                    jugador.arma.disparaJugador(npc, pelea, atacable)
                }else{
                    opcionesPelea(jugador,npc,atacable,pelea)
                }
            2-> jugador.arma.pegarMelee(pelea, npc)
            3-> jugador.curarse()
            4-> jugador.arma.recargar()
            5-> jugador.acortarDistancia(pelea)
            6-> jugador.huir(npc)
        }
    }

    fun opcionesPeleaNpc( jugador: Jugador, npc: Enemigo, atacable: Atacable, pelea: Pelea ) {
        mostrarinfo("1. Disparar")
        mostrarinfo("2. Curarse")

        val opcion = npc.desicionRandom()
        when (opcion){
            1-> if (npc.arma.comprobarMuncion()) {
                npc.arma.disparaNpc(jugador, pelea, atacable)
            }else{
                opcionesPelea(jugador,npc,atacable,pelea)
            }
            2-> npc.curarse()
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
        mostrarinfo("Escoge tu opcion: ")
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
                mostrarinfo("ERROR, escoge un valor correcto")
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
        mostrarinfo("Introduzca un numero entre 1-5")

        var numjugador = 0
        numjugador = opciones(5)
        var numerodado = Random.nextInt(1,6) //genera un numero aleatorio entre el 1 y el 5


        if (numjugador == numerodado){
            mostrarinfo("Has tenido suerte") //, Textcolor.color que quiera
            return true
        }else{
            mostrarinfo("No has acertado.",)
            return false
        }
    }



     fun funcionamientoJuego(){
        mostrarinfo("Deseas que te explique como funciona el juego? \n 1.Si \n 2.No", TextColors.brightMagenta)
        val respuesta = opciones(2)

        when (respuesta){
            1->mostrarinfo("El juego consta de 3 peleas, te vas a enfrentar contra 3 enemigos totalmente Random, Cada enemigo tiene caracteristicas distintas y puede hacer mas o menos daño dependiendo del arma que tenga.",
                TextColors.blue
            )
            2->mostrarinfo("Suerte... la vas a necesitar", TextColors.black)
        }
    }
     fun funcionamientoArmas(){
        mostrarinfo("Deseas que te explique como funcionan las armas?  \n 1.Si \n 2.No",
            TextColors.brightMagenta
        )
        val respuesta = opciones(2)

        when (respuesta){
            1-> mostrarinfo("Cada arma tiene un daño totalmente distinto \n" +
                    "\t Revolver -> Hace 2 de daño al disparar y 1 al golpear a melee, puedes recargar y mostrar la informacion de este para comprobar las balas \n" +
                    "\t Escopeta -> Dependiendo de la distancia que haya entre tu y tu oponente hara mas daño o no, puedes pegar a melee lo cual hara 1 de daño e igual que con todas las armas puedes recargar y mostrar la informacion de tu arma \n " +
                    "\t Escopeta de larga distancia -> Esta escopeta tiene la caracteristica que desde lejos inflinge 4 puntos de daño y como con las demas puedes pegar a melee y mostrar la informacion de esta \n" +
                    "\t Cuchillo -> Podras lanzar cuchillos lo cual inflingira 1 punto de daño pero en cambio si pegas a melee con este inflingiras 5 puntos de vida, pero tienes que estar cerca para poder acertar el golpe",
                TextColors.blue
            )
            2-> mostrarinfo("Suerte... la vas a necesitar", TextColors.black)
        }
    }

    fun mostrarinfo(mensaje:String, color:TextColors = TextColors.brightWhite){// pasar por parametro el mensaje y listo
        terminal.println(color(mensaje)) // esta bien?
    }



    fun historia1(){
        val principal1 =
                    "Llegas a la ciudad de la que tanto se habla ya que se supone que en ella se encuentra el laboratorio del Doctor Heisenberg \n" +
                    "Te bajas de tu caballo porque observas lo que parece ser un hombre que lo acaban de echar de un bar... La habra liado ahi dentro\n" +
                    "Te observa, se percata de que lo estas viendo y te dice 'Que estás mirando tu Payaso'"

        val principal2 =
                    "Llegas a la ciudad de la que tanto se habla ya que se supone que en ella se encuentra el laboratorio del Doctor Heisenberg \n" +
                    "Mientras te vas acercando a la ubicación un hombre te para y te pregunta donde vas \n" +
                    "Al decirle que vas al laboratorio del Doctor Heisenberg rapidamente el hombre saca el arma y te apunta con ella"

        val principal3 =
                    "Llegas a la ciudad de la que tanto se habla ya que se supone que en ella se encuentra el laboratorio del Doctor Heisenberg \n" +
                    "Nada más entrar en la ciudad ves como un hombre empuja fuera de una casa a una mujer \n" +
                    "Te acercas a la mujer y esta entre sollozos te pide ayuda, te cuenta brevemente que el que la acaba de empujar es su marido el cual es un hombre agresivo y que esta harta \n" +
                    "Levantas la mirada, te bajas del caballo y llamas al hombre, a lo que este sin mediar palabra pega un tiro al cielo y te apunta con su arma"


        val listahistorias = listOf(principal1, principal2, principal3) // crear una lista con todas las historias
        val historiaEscogida = listahistorias.random() // escoge una historia Random
        mostrarinfo(historiaEscogida)

    }

    fun historia2(){
        val medio1 = "Una vez pasado el ligero problema que acabas de tener, recuerdas que tu mision es llegar al laboratorio del Doctor Heisenberg porque tienes que recoger algo que este te tiene que entregar \n" +
                     "Te encuentras a escasas calles del laboratorio, sientes como algo te susurra a la espalda, te giras, y no ves nada ni a nadie, te comienzas a poner nervioso \n" +
                     "Serán los nervios, piensas, pero de repente escuchas de nuevo algo pero esta vez es a tu lado izquiero, sin dejar de mirar al frente ves como una silueta que está a tu lado, pero cuando miras ya no está \n" +
                     "'Puedo verte, pero no mirarte' dices, a lo que esa cosa que esta a tu lado se rie y dice 'Los inutiles como tu no son capaces de verme.'"

        val listahistorias1 = listOf(medio1) // crear una lista con todas las historias
        val historiaEscogida = listahistorias1.random() // escoge una historia Random
        mostrarinfo(historiaEscogida)
    }
}