package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class Revolver(var cantidadMunicion:Int, private val municionTope: Int = 6):
    Atacable {
    override val danio = 2

    /**
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean =  cantidadMunicion >0

    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param npc  al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?,pelea: Pelea,atacable: Atacable){
        GestionConsola.mostrarinfo("Disparas tu ${TipoArma.REVOLVER.desc} e inflinges $danio de vida")
        cantidadMunicion--
        npc?.recibirDaño(danio)
    }

    /**
     * El NPC te dispara contra te baja la vida
     *
     * @param jugador Jugador al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Dispara su ${TipoArma.REVOLVER.desc} y te quita $danio de vida ")
        cantidadMunicion--
        jugador.recibirDaño(danio)
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(){
        cantidadMunicion = municionTope
         GestionConsola.mostrarinfo("Recargas tu ${TipoArma.REVOLVER.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos, fallas
     *@param pelea Pelea en la que estas metido
     * @param npc Npc enemigo automatizado que recibe el daño
     */
    override fun pegarMelee(pelea: Pelea,npc: Enemigo?){
        if (pelea.mostrarDistancia() <=1){
            GestionConsola.mostrarinfo("Le pegas a melee al enemigo y le quitas 1 de vida")
            npc?.vidas = npc?.vidas!! - 1 //no se que es esto lo ha puesto el intellij
            GestionConsola.mostrarinfo("${npc?.info()}")
        }else{
            GestionConsola.mostrarinfo("No llegas y por tanto no haces daño")
        }
    }

    /**
     * Inspeccionas tu arma
     */
    override fun inspeccionar(){
        GestionConsola.mostrarinfo("Tu arma es un ${TipoArma.REVOLVER.desc}, tus balas actuales son $cantidadMunicion y la máxima posible $municionTope")
    }
}
