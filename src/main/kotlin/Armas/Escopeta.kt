package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class Escopeta(var cantidadMunicion:Int, private val municionTope: Int = 2):
    Atacable {
    override var danio = 2

    /**
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean =  cantidadMunicion >0

    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param npc npc al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?,pelea: Pelea,atacable: Atacable){

        if (pelea.mostrarDistancia() < 6){ //segun lo cerca que estén la escopeta hará mas o menos daño
            this.danio = 3
        }else if (pelea.mostrarDistancia() < 4){
            this.danio = 4
        }
        else if (pelea.mostrarDistancia() <2){
            this.danio = 5
        }else{
            this.danio = 2
        }

        GestionConsola.mostrarinfo("Disparas con tu ${TipoArma.ESCOPETA.desc} e inflinges $danio de vida")
        cantidadMunicion--
        npc?.recibirDaño(danio)

    }

    /**
     * El NPC te dipara y te baja la vida
     *
     * @param jugador  al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Dispara su ${TipoArma.ESCOPETA.desc} y te quita $danio puntos de vida")
        cantidadMunicion--
        jugador.recibirDaño(danio)
    }


    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(){
        cantidadMunicion = municionTope
         GestionConsola.mostrarinfo("Recargas tu ${TipoArma.ESCOPETA.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     * El npc recibe el daño
     * @param pelea Pelea en la que estas metido
     * @param npc Npc que recibe el daño
     */
    override fun pegarMelee(pelea: Pelea, npc:Enemigo?){
         if (pelea.mostrarDistancia() <=1){
            GestionConsola.mostrarinfo("Le pegas a melee al enemigo y le quitas 1 de vida")
             npc?.vidas = npc?.vidas!! - 1
            GestionConsola.mostrarinfo("${npc?.info()}")
        }else{
            GestionConsola.mostrarinfo("No llegas y por tanto no haces daño")
        }
    }

    /**
     * Inspeccionas el arma
     */
    override fun inspeccionar(){
         GestionConsola.mostrarinfo("Tu arma actual es una ${TipoArma.ESCOPETA.desc} de doble barril, actualmente tienes $cantidadMunicion")
    }
}
