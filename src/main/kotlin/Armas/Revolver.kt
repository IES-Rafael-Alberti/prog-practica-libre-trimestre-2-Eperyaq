package org.practicatrim2.Armas

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
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador: Jugador,pelea: Pelea,atacable: Atacable){
        if (cantidadMunicion >0) {
            println("Disparas tu ${TipoArma.REVOLVER.desc} e inflinges $danio")
            cantidadMunicion--
            jugador.vidas -= danio // cambiar aqui al npc que es al que le ha bajado la vida
        }else{
            println("No tienes suficiente municion")
            GestionConsola.opcionesPelea(jugador,atacable,pelea)
        }
         jugador.info()
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(){
            cantidadMunicion = municionTope
             println("Recargas tu ${TipoArma.REVOLVER.desc} con $municionTope balas")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos, fallas
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
        println("Tu arma es un ${TipoArma.REVOLVER.desc}, tus balas actuales son $cantidadMunicion y la máxima posible $municionTope")
    }
}
