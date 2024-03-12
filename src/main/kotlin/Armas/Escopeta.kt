package org.practicatrim2.Armas

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
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador: Jugador,pelea: Pelea,atacable: Atacable):Int{

        if (pelea.distancia < 6){ //segun lo cerca que estén la escopeta hará mas o menos daño
            this.danio = 3
        }else if (pelea.distancia < 4){
            this.danio = 4
        }
        else if (pelea.distancia <2){
            this.danio = 5
        }else{
            this.danio = 2
        }

        println("Disparas con tu ${TipoArma.ESCOPETA.desc} e inflinges $danio")
        cantidadMunicion--
        return danio
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(){
        cantidadMunicion = municionTope
         println("Recargas tu ${TipoArma.ESCOPETA.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     *
     */
    override fun pegarMelee(pelea: Pelea, jugador: Jugador){
         if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 1 de vida")
            jugador.vidas--
            println(jugador.info())
        }else{
            println("No llegas y por tanto no haces daño")
        }
    }

    override fun inspeccionar(){
         println("Tu arma actual es una ${TipoArma.ESCOPETA.desc} de doble barril, actualmente tienes $cantidadMunicion")
    }
}
