package org.practicatrim2

import org.practicatrim2.Armas.Atacable


class Jugador(val nombre:String, val arma:Atacable, var vidas:Int):Persona {


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

    override fun curarse() {
        println("Te curas 1 de vida")
        vidas++
        println(info())
    }

    override fun huir() { // esto va aqui??
        println("Intentas huir...")
        GestionConsola.dado()

    }
}
