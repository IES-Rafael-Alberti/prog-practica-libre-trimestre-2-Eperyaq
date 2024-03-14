package org.practicatrim2

import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.TipoArma
import kotlin.random.Random


class Enemigo(val nombre:String, val arma:Atacable, var vidas:Int) {
    private val vidaMaxima = 10


    /**
     * Informacion sobre tu personaje
     */
    fun info() = GestionConsola.mostrarinfo("A $nombre le quedan $vidas vidas.")


    /**
     * Te curas 1 de vida
     */
    fun curarse() {
        val numeroRandom = Random.nextInt(1,6)
        if (vidas == vidaMaxima){
            GestionConsola.mostrarinfo("No puedes curarte con la salud máxima")
        }else {
            GestionConsola.mostrarinfo("Se curas $numeroRandom de vida")
            vidas+= numeroRandom
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

    fun desicionRandom(): Int{
        val disparar = 1
        val curaUrgente = 2

        if (vidas <=2){
            return curaUrgente
        }else{
            return disparar
        }
    }
}
