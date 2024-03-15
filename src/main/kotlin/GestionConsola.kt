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
     * Hasta que no introduce un numero correcto no va a parar de preguntar por ese numero
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

    /**
     * Muestra un menú de las posibles acciones que puedes realizar
     * @param jugador Jugador principal
     * @param npc Npc  enemigo automatizado
     * @param pelea Pelea en la que estas involucrado y por ese este menu
     * @param atacable Arma que usas
     */
    fun mostrarAtacarHuir(jugador: Jugador,npc: Enemigo?, pelea: Pelea, atacable: Atacable){
        var num = 0

        mostrarinfo("1.Pelear")
        mostrarinfo("Un verdadero hombre, cuando es faltado al respeto lo unico que quiere es SANGRE!", TextColors.red)
        num = opciones(1)

        when (num) {
            1 -> pelea.iniciarPelea(jugador, npc, pelea, atacable)
        }
    }

    /**
     * Opciones en la pelea
     * @param jugador Jugador principal
     * @param npc Npc enemigo controlado por la maquina
     * @param atacable Arma que usas
     * @param pelea Pelea en la que estas involucrada
     */
    fun opcionesPelea(jugador: Jugador, npc:Enemigo?, atacable: Atacable, pelea: Pelea ) {
        mostrarinfo("1. Disparar")
        mostrarinfo("2. Pegar a Melee")
        mostrarinfo("3. Curarse")
        mostrarinfo("4. Recargar")
        mostrarinfo("5. Huir")

        val opcion = opciones(5)
        when (opcion){
            1-> if (jugador.arma.comprobarMuncion()) {
                    jugador.arma.disparaJugador(npc, pelea, atacable)
                }else{
                    mostrarinfo("No tienes suficientes balas")
                    opcionesPelea(jugador,npc,atacable,pelea)
                }
            2-> jugador.arma.pegarMelee(pelea, npc)
            3-> jugador.curarse()
            4-> jugador.arma.recargar()
            5-> jugador.huir(npc)
        }
    }

    /**
     * Opciones de la pelea del npc
     * @param jugador Jugador principal, lo necesitamos para las otras funciones de esta
     * @param npc Enemigo principal que en este caso es el que va a realizar el ataque
     * @param atacable Arma con la que te va a atacar el npc
     * @param pelea Pelea que estais teniendo
     */
    fun opcionesPeleaNpc( jugador: Jugador, npc: Enemigo?, atacable: Atacable, pelea: Pelea ) {
        mostrarinfo("1. Disparar")
        mostrarinfo("2. Curarse")
        mostrarinfo("3. Recargar")

        val opcion = npc?.desicionRandom(atacable)
        when (opcion){
            1-> if (npc.arma.comprobarMuncion()) {
                npc.arma.disparaNpc(jugador, pelea, atacable)
            }else{
                opcionesPeleaNpc(jugador,npc,atacable,pelea)
            }
            2-> npc.curarse()
            3-> npc.arma.recargar()
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
     * @return true Si has tenido suerte y has acertado el numero del dado.
     * false Si no has tenido suerte y no has acertado el numero del dado.
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


    /**
     * Te muestra como funciona el juego con unos string
     */
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

    /**
     * Te explica el funcionamiento de las armas
     */
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

    /**
     * Funcion que hay que pasarle un String para no usar println
     * @param mensaje Mensaje que quieres mostrar
     * @param color Color que le pasas para la libreria mordant, no hace falta pasarlo tiene un color default
     */
    fun mostrarinfo(mensaje:String, color:TextColors = TextColors.brightWhite){// pasar por parametro el mensaje y listo
        terminal.println(color(mensaje)) // esta bien?
    }

    /**
     * Menu para comenzar la pelea
     * @param jugador Jugador principal
     * @param npc Enemigo automatizado
     * @param pelea Pelea en la que estas metido
     * @param atacable Arma que estas usando
     */
    fun mostrarcositas(jugador: Jugador, npc: Enemigo?, pelea:Pelea, atacable: Atacable){
        funcionamientoJuego()
        mostrarinfo("\n \n")// para darle espacio entre una pregunta y otra
        funcionamientoArmas()

        clearConsole()
        historia1()

        clearConsole()
        mostrarinfo("Te enfrentas contra ${npc?.nombre}, la distancia actual es: ${pelea.mostrarDistancia()} metros")
        mostrarAtacarHuir(jugador,npc, pelea, atacable)
    }

    /**
     * Menu para comenzar la segunda pelea
     *
     * @param jugador Jugador principal
     * @param npc2 Enemigo 2 automatizado
     * @param pelea Pelea en la que estas metido
     * @param atacable Arma que estas usando
     */
    fun mostrarcositas2(jugador: Jugador, npc2:Enemigo?, pelea: Pelea,atacable: Atacable){

        clearConsole()
        historia2()

        clearConsole()

        mostrarinfo("Te enfrentas contra ${npc2?.nombre}, la distancia actual es: ${pelea.mostrarDistancia()} metros")
        pelea.iniciarPelea2(jugador, npc2,pelea,atacable)

    }

    /**
     * Menu para comenzar la tercera pelea
     *
     * @param jugador Jugador principal
     * @param npc3 Enemigo 3 automatizado
     * @param pelea Pelea en la que estas metido
     * @param atacable Arma que estas usando
     */
    fun mostrarcositas3(jugador: Jugador, npc3: Enemigo?,pelea: Pelea,atacable: Atacable){
        clearConsole()
        historia3()

        clearConsole()

        mostrarinfo("Te enfrentas contra ${npc3?.nombre}, la distancia actual es: ${pelea.mostrarDistancia()} metros")
        pelea.iniciarPelea3(jugador, npc3,pelea,atacable)

        finHistoria()
    }

    /**
     * Pregunta si quieres seguir con la aventura y te muestra unas opciones a escoger
     */
     fun preguntarSeguir():Boolean{
        mostrarinfo("Quieres continuar la aventura? \n 1.Si \n 2.No")

        val num = opciones(2)
        return when (num){
            1-> true
            2 ->false
            else -> false // para que deje de molestar el IDE con que hace falta una return expresion
        }
    }

    /**
     * Muestra una barra para separar texto
     */
    fun clearConsole() {
        mostrarinfo("\n---------------------------------------------------------------------------------------------------------------------\n",
            TextColors.brightMagenta
        )
    }

    //--------------------------------------- HISTORIA ------------------------------------------------//
    /**
     * Historia incial
     * Crea una lista mete las historias que hayan y escoge una al azar
     */
    private fun historia1(){
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
        mostrarinfo(historiaEscogida, TextColors.cyan)

    }
    /**
     * Historia Media
     * Crea una lista mete las historias que hayan y escoge una al azar
     */
    private fun historia2(){
        val medio1 = "Una vez pasado el ligero problema que acabas de tener, recuerdas que tu mision es llegar al laboratorio del Doctor Heisenberg porque tienes que recoger algo que este te tiene que entregar \n" +
                     "Te encuentras a escasas calles del laboratorio, sientes como algo te susurra a la espalda, te giras, y no ves nada ni a nadie, te comienzas a poner nervioso \n" +
                     "Serán los nervios, piensas, pero de repente escuchas de nuevo algo pero esta vez es a tu lado izquiero, sin dejar de mirar al frente ves como una silueta que está a tu lado, pero cuando miras ya no está \n" +
                     "'Puedo verte, pero no mirarte' dices, a lo que esa cosa que esta a tu lado se rie y dice 'Los inutiles como tu no son capaces de verme.'"

        val medio2 = "Una vez pasado el ligero problema que acabas de tener, recuerdas que tu mision es llegar al laboratorio del Doctor Heisenberg porque tienes que recoger algo que este te tiene que entregar \n" +
                     "Después de la pelea te sientes algo sediento, por lo que te aproximas a un bar a echarte un buchito de whisky \n" +
                     "Una vez dentro del bar, le pides al camarero uno de sus mejores whisky, te lo sirve y le pegas el primer buche, relajado suspiras y la persona sentada al lado tuya te dice \n" +
                     "'Muy cansado despues de haber asesinado a ese hombre?' asientes con la cabeza, y se te pasa por la mente una pregunta ¿Como sabe este hombre a quien he matado si no recuerdo haberlo visto? \n" +
                     "Cuando miras hacia el para comprobar si realmente no lo habias visto, este te dice 'Hijo De P*** Acabas de matar a mi Jodido hermano', miras hacia abajo y ves como te está apuntando con su arma"

        val medio3 = "Una vez pasado el ligero problema que acabas de tener, recuerdas que tu mision es llegar al laboratorio del Doctor Heisenberg porque tienes que recoger algo que este te tiene que entregar \n" +
                     "Montado en tu caballo, y como buen hombre del oeste que eres, vas con la viña de trigo en la boca. \n" +
                    "A lo que un extraño que esta andando por ahi te mira y te dice '¿Tu quien te crees Clint Eastwood?' \n" +
                    "Pasas de el y continuas tu camino.\n" +
                    "El extraño no se tomó muy bien que pasaras de el y pego un tiro cerca de tu caballo lo que lo asusta y este encabrita y te tira. \n" +
                    "Te levantas encabronado y ves que el otro te está apuntando con su arma preparado para dispararte"
        val listahistorias2 = listOf(medio1, medio2, medio3) // crear una lista con todas las historias
        val historiaEscogida = listahistorias2.random() // escoge una historia Random
        mostrarinfo(historiaEscogida, TextColors.cyan)
    }

    /**
     * Historia final
     * Crea una lista mete las historias que hayan y escoge una al azar
     */
    private fun historia3(){
        val fin1 = "Después de haber pasado por todo lo que has pasado por fin llegas al laboratorio, llamas a la puerta, te abren, te miran de arriba a abajo y te dejan pasar \n" +
                    "Dentro, te encuentras con que el Doctor esta tirado en el suelo sangrando, te alertas y empiezas a mirar a todos lados, a lo que ves una cara familiar \n" +
                    "Frunces el ceño y lo unico que es capaz de salir de boca es '¿Diego? ¿Por que?' a lo que el te mira, saca su arma y te dice 'Preparate para morir'"

        val fin2 = "Después de haber pasado por todo lo que has pasado por fin llegas al laboratorio, llamas a la puerta, te abren, te miran de arriba a abajo y te dejan pasar \n"
                    "Dentro de encuentras con el Doctor, hablas un poco con el y te cuenta que lo que te iban a entregar es un libro el cual contiene el secreto para aprobar DAW \n" +
                    "El doctor pasa dentro de una sala y te pide que esperes fuera, cuando el doctor entra te miras un poco en el cristal que hay para mirar dentro de la habitacion y ves a alguien familiar \n" +
                    "Dejas de fijarte en ti y te fijas en la persona de dentro. Resulta ser Diego un gran amigo tuyo, te alegras y esperas a que salga con el doctor \n" +
                    "Cuando salen, el Doctor cae desplomado y Diego sale detras, 'Pensabas salir con esto?' Pregunta, te preparas para lo que pueda pasar y asientes con la cabeza \n" +
                    "A lo que Diego te mira y saca su arma"

        val fin3 = "Después de haber pasado por todo lo que has pasado por fin llegas al laboratorio, llamas a la puerta, te abren, te miran de arriba a abajo y te dejan pasar \n" +
                    "Entrando por la puerta te encuentras con que no hay nadie, preguntas por el Doctor, te dicen que ha salido un momento y que esperes un momento \n" +
                    "Pasan los minutos e incluso alguna hora, desesperado preguntas de nuevo, te dicen que no seas impaciente y que tiene que estar al llegar, te intentas calmar \n" +
                    "Llega el doctor con otra persona más que por algun motivo te resulta familiar, pasas de esa persona y vas a hablar con el Doctor, este te lleva a una habitacion y te entrega el objeto que resulta ser el secreto para aprobar DAW \n" +
                    "Cuando sales de la habitación ves a todos los guardias muertos y a la persona que te resultaba familiar apuntandote con su arma, 'QUE!?' exclamas, a lo que la otra persona te mira y te dice 'Yo Diego no te dejaré salir de aqui con vida!'"

        val listahistorias3 = listOf(fin1, fin2, fin3) // crear una lista con todas las historias
        val historiaEscogida = listahistorias3.random() // escoge una historia Random
        mostrarinfo(historiaEscogida, TextColors.cyan)

    }
    private fun finHistoria(){
        mostrarinfo("\n Una vez derrotado el enemigo Diego Cano, sales del laboratorio del Doctor te montas en tu caballo y te vas, mientras montas a caballo del cansancio te caes al suelo y del golpe... \n" +
        "Te levantas agitado... Todo resulto ser una pesadilla...", TextColors.green)
    }

}