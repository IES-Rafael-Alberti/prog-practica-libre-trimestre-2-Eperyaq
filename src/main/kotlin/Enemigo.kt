package org.practicatrim2

import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.TipoArma
import kotlin.random.Random


class Enemigo(val nombre:String, val arma:Atacable, var vidas:Int) {
    private val vidaMaxima = 10


    /**
     * Informacion sobre el personaje enemigo
     */
    fun info() = GestionConsola.mostrarinfo("A $nombre le quedan $vidas vidas.")


    /**
     * se cura 1 de vida el npc
     */
    fun curarse() {
        if (vidas == vidaMaxima){
            GestionConsola.mostrarinfo("No puedes curarte con la salud máxima")
        }else {
            GestionConsola.mostrarinfo("Se cura 1 de vida")
            vidas++
            GestionConsola.mostrarinfo("${info()}")
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
        GestionConsola.mostrarinfo("La vida de $nombre es $vidas")
    }

    /**
     * Dependiendo de la necesidad que tenga el enemigo usará una cosa u otra
     * @param atacable el arma con el que va a atacar
     * @return opcion elegida por el npc aunque realmente es random dependiendo de lo que necesite
     */
    fun desicionRandom(atacable: Atacable): Int{
        val disparar = 1
        val curaUrgente = 2
        val recargar = 3

        return if (vidas <=2){
            curaUrgente
        }else if (atacable.comprobarMuncion()) { //si tiene municion dispara, si no, recarga
            disparar
        }else{
            recargar
        }
    }


}
