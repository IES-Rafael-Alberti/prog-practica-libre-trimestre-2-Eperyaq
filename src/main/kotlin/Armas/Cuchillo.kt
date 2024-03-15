package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class Cuchillo(var cantidadCuchillos:Int): Atacable {
    override val danio = 2
    companion object{
        private val cuchillosRespuesto: Int = 5 // la cantidad de cuchillos máxima que puede tener
    }

    /**
     * Lanzas un cuchillo contra tu oponente y le bajas la vida
     *
     * @param npc  al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Lanzas tu ${TipoArma.CUCHILLO.desc} e inflinges $danio de vida")
        cantidadCuchillos--
        npc?.recibirDaño(danio)
    }

    /**
     * El NPC te Lanza un cuchillo que te baja la vida
     *
     * @param jugador Jugador al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Lanza su ${TipoArma.CUCHILLO.desc} y te quita $danio puntos de vida ")
        cantidadCuchillos--
        jugador.recibirDaño(danio)

    }

    /**
     * PRINCIPIO TREMENDAMENTE SOLIDO (lo quite de disparar)
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean{
        if (cantidadCuchillos >0)
            return true
        else {
            GestionConsola.mostrarinfo("No tienes suficientes cuchillos")
            return false
        }
    }

    /**
     * Recargas tus cuchillos
     */
    override fun recargar() {
        cantidadCuchillos = cuchillosRespuesto
        GestionConsola.mostrarinfo("Recargas tu ${TipoArma.CUCHILLO.desc} y ahora tienes $cantidadCuchillos Cuchillos más")
    }

    /**
     * Pegas navajazo a corta distancia que hace bastante daño, si no estas dentro del rango, fallas
     * El npc recibe el daño
     * @param pelea Pelea en la que estas metido
     * @param npc Npc que recibe el daño
     */
    override fun pegarMelee(pelea: Pelea, npc:Enemigo?){
        if (pelea.mostrarDistancia() <=1){
            GestionConsola.mostrarinfo("Le pegas a melee al enemigo y le quitas 5 de vida")
            npc?.vidas = npc?.vidas!! - 5
            GestionConsola.mostrarinfo("${npc.info()}")
        }else{
            GestionConsola.mostrarinfo("No llegas y por tanto no haces daño")
        }
    }

    /**
     * Inspeccionas el arma
     */
    override fun inspeccionar(){
        GestionConsola.mostrarinfo("Tienes un ${TipoArma.CUCHILLO.desc}, tus chuchillos actuales son $cantidadCuchillos y los de repuesto son $cuchillosRespuesto")
    }
}
