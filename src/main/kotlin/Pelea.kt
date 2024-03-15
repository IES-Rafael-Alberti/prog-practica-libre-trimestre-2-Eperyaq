package org.practicatrim2


import com.github.ajalt.mordant.rendering.TextColors.*
import org.practicatrim2.Armas.Atacable
import kotlin.random.Random

class Pelea(val jugador:Jugador, val npc: Enemigo?, val npc2: Enemigo?, val npc3:Enemigo?) {
    companion object {
        var distancia = Random.nextInt(1, 10)
    }

    /**
     * Muestra la distancia para poder usarla en otras funciones
     */
    fun mostrarDistancia() = distancia

    /**
     * Inicia una emocionante pelea en la que pasan muchas cosas
     * @param jugador Jugador principal que está en la pelea
     * @param npc Npc máquina automatizado
     * @param pelea Pelea que está ocurriendo en el momento
     * @param atacable Arma que se está usando en la pelea
     */
    fun iniciarPelea(jugador: Jugador, npc:Enemigo?,pelea: Pelea, atacable: Atacable) {

        GestionConsola.mostrarinfo("\nQue comience el duelo!\n")

        while (jugador.estavivo() && npc!!.estavivo()) {
            //turno del Jugador
            GestionConsola.mostrarinfo("${jugador.nombre} Tu arma es😈 ${jugador.arma.javaClass.simpleName}. Que quieres hacer?")
            GestionConsola.opcionesPelea(jugador, npc, atacable, pelea)

            //comprueba si está vivo el enemigo y si no es asi, muestra mensaje de que esta muerto
            if (!npc.estavivo()) {
                GestionConsola.mostrarinfo("${npc.nombre} Ha muerto", green)
            } else {

                GestionConsola.clearConsole()
                //turno de la máquina
                GestionConsola.mostrarinfo("${npc.nombre} Tu arma es😎 ${npc.arma.javaClass.simpleName}. Que quieres hacer?")
                GestionConsola.opcionesPeleaNpc(jugador, npc, atacable, pelea)

                //comprueba si el jugador esta vivo, si no muestra un mensaje de muerte
                if (!jugador.estavivo()) {
                    GestionConsola.mostrarinfo(" \n ${jugador.nombre} Ha muerto \n")
                    GestionConsola.mostrarinfo("FIN DEL JUEGO", brightRed)
                    //lo de abajo simplemente son frase para cuando te mate cada persona especifica
                    when (npc.nombre) {
                        "Viti El Loco" -> {
                            GestionConsola.mostrarinfo("Jaaaa jaaaa jaaaaa te pica el culo?", brightRed)
                        }
                        "David El Mataescorias" -> {
                            GestionConsola.mostrarinfo("No me vea' como estamos", brightRed)
                        }
                        "Pablo El VitruvianMan" -> {
                            GestionConsola.mostrarinfo("Aún ni te acercas a Toji Fushiguro...", brightRed)
                        }
                        "Jose El Cuñao" -> {
                            GestionConsola.mostrarinfo("El niño paga", brightRed)
                        }
                        else -> {
                            GestionConsola.mostrarinfo("Pobre Infeliz...", brightRed) //por si quieres añadir algun enemigo y este no tiene linea de mensaje
                        }
                    }
                }else{
                    GestionConsola.clearConsole()
                }
            }
        }


    }
    //------------------------------------ SEGUNDA PELEA ---------------------------------------------------------------//
    /**
     * Inicia una emocionante pelea por segunda vez porque no he sido capaz de hacerlo solo con una
     * @param jugador Jugador principal que está en la pelea
     * @param npc2 Npc máquina automatizado
     * @param pelea Pelea que está ocurriendo en el momento
     * @param atacable Arma que se está usando en la pelea
     */
     fun iniciarPelea2(jugador: Jugador, npc2:Enemigo?,pelea: Pelea, atacable: Atacable) {

        GestionConsola.mostrarinfo("\nQue comience el duelo!\n")

        while (jugador.estavivo() && npc2!!.estavivo()) {
            //turno del Jugador
            GestionConsola.mostrarinfo("${jugador.nombre} Tu arma es😈 ${jugador.arma.javaClass.simpleName}. Que quieres hacer?")
            GestionConsola.opcionesPelea(jugador, npc2, atacable, pelea)

            //comprueba si esta vivo el enemigo y si no es asi, muestra mensaje de que esta muerto
            if (!npc2.estavivo()) {
                GestionConsola.mostrarinfo("${npc2.nombre} Ha muerto")
            } else {

                GestionConsola.clearConsole()
                //turno de la máquina
                GestionConsola.mostrarinfo("${npc2.nombre} Tu arma es😎 ${npc2.arma.javaClass.simpleName}. Que quieres hacer?")
                GestionConsola.opcionesPeleaNpc(jugador, npc2, atacable, pelea)

                //comprueba si el jugador esta vivo, si no muestra un mensaje de muerte
                if (!jugador.estavivo()) {
                    GestionConsola.mostrarinfo("${jugador.nombre} Ha muerto")
                    GestionConsola.mostrarinfo("FIN DEL JUEGO", brightRed)

                    //Lo mismo de arriba linea de frases para cada enemigo
                    when (npc?.nombre) {
                        "Viti El Loco" -> {
                            GestionConsola.mostrarinfo("Jaaaa jaaaa jaaaaa te pica el culo?", brightRed)
                        }
                        "David El Mataescorias" -> {
                            GestionConsola.mostrarinfo("No me vea' como estamos", brightRed)
                        }
                        "Pablo El VitruvianMan" -> {
                            GestionConsola.mostrarinfo("Aún ni te acercas a Toji Fushiguro...", brightRed)
                        }
                        "Jose El Cuñao" -> {
                            GestionConsola.mostrarinfo("El niño paga", brightRed)
                        }
                        else -> {
                            GestionConsola.mostrarinfo("Pobre Infeliz...", brightRed) //por si quieres añadir algun enemigo y este no tiene linea de mensaje
                        }
                    }
                }else{
                    GestionConsola.clearConsole()
                }
            }
        }
    }
    //------------------------------------ TERCERA PELEA ---------------------------------------------------------------//
    /**
     * Inicia una emocionante pelea por tercera vez porque no he sido capaz de hacerlo solo con una
     * @param jugador Jugador principal que está en la pelea
     * @param npc3 Npc máquina automatizado
     * @param pelea Pelea que está ocurriendo en el momento
     * @param atacable Arma que se está usando en la pelea
     */
     fun iniciarPelea3(jugador: Jugador, npc3:Enemigo?,pelea: Pelea, atacable: Atacable) {

        GestionConsola.mostrarinfo("\nQue comience el duelo!\n")

        while (jugador.estavivo() && npc3!!.estavivo()) { //le pongo !! porque segun mi codigo y mi main nunca será nulo a no ser que se cambie a posta
            //turno del Jugador
            GestionConsola.mostrarinfo("${jugador.nombre} Tu arma es😈 ${jugador.arma.javaClass.simpleName}. Que quieres hacer?")
            GestionConsola.opcionesPelea(jugador, npc3, atacable, pelea)

            //comprueba si esta vivo el enemigo y si no es asi, muestra mensaje de que esta muerto
            if (!npc3.estavivo()) {
                GestionConsola.mostrarinfo("${npc3.nombre} Ha muerto")
            } else {

                GestionConsola.clearConsole()
                //turno de la máquina
                GestionConsola.mostrarinfo("${npc3.nombre} Tu arma es😎 ${npc3.arma.javaClass.simpleName}. Que quieres hacer?")
                GestionConsola.opcionesPeleaNpc(jugador, npc3, atacable, pelea)

                /* comprueba si el jugador está vivo, si no muestra un mensaje de muerte */
                if (!jugador.estavivo()) {
                    GestionConsola.mostrarinfo("${jugador.nombre} Ha muerto")
                    GestionConsola.mostrarinfo("FIN DEL JUEGO", brightRed)
                    GestionConsola.mostrarinfo("Mira que os dije que a la programacion hay que echarle horas...", brightRed)
                }else{
                    GestionConsola.clearConsole()
                }
            }
        }
    }


}


