package org.practicatrim2

import org.practicatrim2.Armas.TipoArma

class Jugador(val nombre:String, val arma: TipoArma, var vidas:Int):Persona {


    override fun seguir_camino() = println("Sigues tu camino...")


    override fun insultar() = println("$!#*€")


    override fun info() = println("$nombre tiene de arma $arma y le quedan $vidas vidas.")


    override fun acortarDistancia(pelea: Pelea){
        if (pelea.distancia <= 1){
            println("No puedes acercarte más")
        }else {
            pelea.distancia -= 1
            println("Acortas un metro de distancia")
        }
    }
}
