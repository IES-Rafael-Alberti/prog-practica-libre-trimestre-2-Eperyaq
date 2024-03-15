package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class EscopetaLargaDistancia(var cantidadMunicion:Int, private val municionTope: Int = 5):
    Atacable {
    override var danio = 4

    /**
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean =  cantidadMunicion >0

    /**
     * Disparas a tu contrincante y le bajas vida
     *
     *@param npc  al que bajarle la vida
     *@param pelea en la que estas involucrado
     *@param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?,pelea: Pelea,atacable: Atacable){
        GestionConsola.mostrarinfo("Disparas tu ${TipoArma.ESCOPETALARGADISTANCIA.desc} e inflinges $danio de vida")
        cantidadMunicion--
        npc?.recibirDaño(danio)
    }

    /**
     * El NPC te dispara y te baja la vida
     *
     * @param jugador Jugador al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Dispara su ${TipoArma.ESCOPETALARGADISTANCIA.desc} y te quita $danio puntos de vida")
        cantidadMunicion--
        jugador.recibirDaño(danio)
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar() {
        cantidadMunicion = municionTope
        GestionConsola.mostrarinfo("Recargas tu ${TipoArma.ESCOPETALARGADISTANCIA.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     *El npc recibe el daño
     * @param pelea Pelea en la que estas metido
     * @param npc Npc que recibe el daño
     */
    override fun pegarMelee(pelea: Pelea, npc: Enemigo?){
        if (pelea.mostrarDistancia() <=1){
            GestionConsola.mostrarinfo("Le pegas a melee al enemigo y le quitas 1 de vida")
            npc?.vidas = npc?.vidas!! - 1
            GestionConsola.mostrarinfo("${npc?.info()}")
        }else{
            GestionConsola.mostrarinfo("No llegas y por tanto no haces daño")
        }
    }

    /**
     * Inspeccionas tu arma
     */
    override fun inspeccionar(){
        GestionConsola.mostrarinfo("Tu arma actual es una ${TipoArma.ESCOPETALARGADISTANCIA.desc}, actualmente tienes $cantidadMunicion")
    }
}
