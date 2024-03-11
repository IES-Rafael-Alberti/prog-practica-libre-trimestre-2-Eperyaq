package org.practicatrim2.Armas

import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class Escopeta(val arma: TipoArma, val tipomunicion:String, var cantidadMunicion:Int, private val municionTope: Int = 2):
    Atacable {
    override var danio = 2
    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador: Jugador, danio:Int, pelea: Pelea){

        if (pelea.distancia < 6){ //segun lo cerca que estén la escopeta hará mas o menos daño
            this.danio = 3
        }else if (pelea.distancia < 4){
            this.danio = 4
        }
        else{
            this.danio = 5
        }

        if (cantidadMunicion >0) {
            println("Disparas tu $arma e inflinges $danio")
            cantidadMunicion--
            jugador.vidas -= danio
        }

         println(jugador.info())
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(){
        cantidadMunicion = municionTope
         println("Recargas tu $arma con $municionTope balas")
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
         println("Tu arma actual es una $arma de doble barril, actualmente tienes $cantidadMunicion")
    }
}
