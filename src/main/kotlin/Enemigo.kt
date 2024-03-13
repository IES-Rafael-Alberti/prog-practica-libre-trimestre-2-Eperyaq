package org.practicatrim2

import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.TipoArma
import kotlin.random.Random


class Enemigo(val nombre:String, val arma:Atacable, var vidas:Int) {
    private val vidaMaxima = 10


    /**
     * Informacion sobre tu personaje
     */
    fun info() = println("A $nombre le quedan $vidas vidas.")


    /**
     * Te curas 1 de vida
     */
    fun curarse() {
        if (vidas == vidaMaxima){
            println("No puedes curarte con la salud máxima")
        }else {
            println("Te curas 1 de vida")
            vidas++
            println(info())
        }
    }


    /**
     * Comprueba si esta vivo
     */
    fun estavivo():Boolean = vidas>0 //si tiene vida esta vivo :D

    /**
     * Recibes el daño del ataque
     * @param [dañoRecibido], la vida que le baja al personaje
     *
     */
    fun recibirDaño(dañoRecibido:Int){
        vidas -= dañoRecibido
        println("La vida de $nombre es $vidas")
    }
}
