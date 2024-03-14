package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class PalodeGomaEspuma():
    Atacable {
    override var danio = 1

    /**
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean{
        GestionConsola.mostrarinfo("Mmmm, que intentas comprobar?")
        return false
    }

    /**
     * Disparas...
     *
     *@param jugador Jugador al que seguro que le haces gracia
     *@param pelea Pelea en la que participas
     */
    override fun disparaJugador(npc: Enemigo ,pelea: Pelea,atacable: Atacable){
        GestionConsola.mostrarinfo("Mmmm, que disparas? rayos laser?")
    }

    /**
     * El NPC te Dispara y te baja la vida
     *
     * @param jugador Jugador al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable) {
        GestionConsola.mostrarinfo("Que pretendes disparar tu tambien? No vales para nada con eso")
    }

    /**
     * Recargas...
     */
    override fun recargar(){
        GestionConsola.mostrarinfo("Que pretendes recargar?")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     * @param pelea en la que estas metido
     * @param npc que recibe el ataque
     */
    override fun pegarMelee(pelea: Pelea, npc: Enemigo){
        if (pelea.distancia <=1){
            GestionConsola.mostrarinfo("Le pegas a melee al enemigo y le quitas 1 de vida")
            npc.vidas -= 20
        }else{
            GestionConsola.mostrarinfo("No llegas y por tanto no haces daño")
        }
    }

    override fun inspeccionar(){
        GestionConsola.mostrarinfo("Tu arma actual es un ${TipoArma.PALOGOMAESPUMA.desc}, y... no se que mas quieres saber la verdad")
    }
}
