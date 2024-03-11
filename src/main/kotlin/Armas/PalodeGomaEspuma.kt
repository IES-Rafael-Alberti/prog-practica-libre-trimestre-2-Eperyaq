package org.practicatrim2.Armas

import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class PalodeGomaEspuma():
    Atacable {
    override var danio = 4

    /**
     * Disparas...
     *
     *@param jugador Jugador al que seguro que le haces gracia
     *@param pelea Pelea en la que participas
     */
    override fun disparar(jugador: Jugador, danio:Int, pelea: Pelea){
        println("Mmmm, que disparas? rayos laser?")
    }

    /**
     * Recargas...
     *
     * @return String graciosete
     */
    override fun recargar(){
        println("Que pretendes recargar?")
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     *
     */
    override fun pegarMelee(pelea: Pelea, jugador: Jugador){
        if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 1 de vida")
            jugador.vidas --
            println(jugador.info())
        }else{
            println("No llegas y por tanto no haces daño")
        }
    }

    override fun inspeccionar(){
        println("Tu arma actual es un ${TipoArma.PALOGOMAESPUMA.desc}, y... no se que mas quieres saber la verdad")
    }
}
