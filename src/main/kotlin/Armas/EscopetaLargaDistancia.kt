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
     *@param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del [jugador]
     */
    override fun disparar(jugador: Jugador,pelea: Pelea,atacable: Atacable):Int{

        println("Disparas tu ${TipoArma.ESCOPETALARGADISTANCIA.desc} e inflinges $danio")
        cantidadMunicion--
        return danio
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar() {
        cantidadMunicion = municionTope
        println("Recargas tu ${TipoArma.ESCOPETALARGADISTANCIA.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     *
     */
    override fun pegarMelee(pelea: Pelea, jugador: Jugador,npc: Enemigo){
        if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 1 de vida")
            jugador.vidas--
            println(jugador.info())
        }else{
            println("No llegas y por tanto no haces daño")
        }
    }

    override fun inspeccionar(){
        println("Tu arma actual es una ${TipoArma.ESCOPETALARGADISTANCIA.desc}, actualmente tienes $cantidadMunicion")
    }
}
