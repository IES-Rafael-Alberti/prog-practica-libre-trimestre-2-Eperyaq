package org.practicatrim2

import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.TipoArma
import kotlin.random.Random


class Jugador(val nombre:String, val arma:Atacable, var vidas:Int):Persona {
    private val vidaMaxima = 10
    private val vidaMinima = 0

    override fun seguir_camino() = println("Sigues tu camino...")

    /**
     * Insultas a tu contrincante y pasas de el pero...
     * Existe una posibilidad muy pequeña de que si te sale un numero random mueres..
     * Nunca se le da la espalda a un enemigo
     */
    override fun insultar(){
        println("$!#*€")

        val numerofijado = 2
        val numerorandom = Random.nextInt(1,11)
        if (numerorandom == numerofijado){
            vidas-= 10
        }
    }

    /**
     * Informacion sobre tu personaje
     */
    override fun info() = println("A $nombre le quedan $vidas vidas.")

    /**
     * Avanzas un metro para acercarte mas al rival
     * @param [pelea], en la que estas metido
     */
    override fun acortarDistancia(pelea: Pelea){
        if (pelea.distancia <= 1){
            println("No puedes acercarte más")
        }else {
            pelea.distancia -= 1
            println("Acortas un metro de distancia")
        }
    }

    /**
     * Te curas 1 de vida
     */
    override fun curarse() {
        if (vidas == vidaMaxima){
            println("No puedes curarte con la salud máxima")
        }else {
            println("Te curas 1 de vida")
            vidas++
            println(info())
        }
    }

    override fun huir() {
        println("Intentas huir...")
        GestionConsola.dado()

        if (GestionConsola.dado()){ //si es true

            //salir de la pelea ya que has tenido suerte con el dado
        }else{
            println("No pudiste huir...")
            //seguir con la pelea
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
