package org.practicatrim2

import com.github.ajalt.mordant.rendering.TextColors
import org.practicatrim2.Armas.Atacable
import org.practicatrim2.Armas.TipoArma
import kotlin.random.Random


class Jugador(val nombre:String, val arma:Atacable, var vidas:Int):Persona {
    private val vidaMaxima = 10


    /**
     * Insultas a tu contrincante y pasas de el pero...
     * Existe una posibilidad muy pequeña de que si te sale un numero random mueres..
     * Nunca se le da la espalda a un enemigo
     */
    override fun insultar(){
        GestionConsola.mostrarinfo("$!#*€")

        val numerofijado = 2 //numero aleatorio, si sale el mismo en el random estas muerto
        val numerorandom = Random.nextInt(1,11)
        if (numerorandom == numerofijado){
            vidas-= 10
            GestionConsola.mostrarinfo("Has muerto... nunca se le da la espalda a un enemigo", TextColors.red)
        }

    }

    /**
     * Informacion sobre tu personaje
     */
    override fun info() = GestionConsola.mostrarinfo("A $nombre le quedan $vidas vidas.")

    /**
     * Avanzas un metro para acercarte mas al rival
     * @param [pelea], en la que estas metido
     */
    override fun acortarDistancia(pelea: Pelea){
        if (pelea.distancia <= 1){
            GestionConsola.mostrarinfo("No puedes acercarte más")
        }else {
            pelea.distancia -= 1
            GestionConsola.mostrarinfo("Acortas un metro, la distancia actual es: ${pelea.distancia} metros", TextColors.green)
        }
    }

    /**
     * Te curas 1 de vida
     */
    override fun curarse() {
        if (vidas == vidaMaxima){
            GestionConsola.mostrarinfo("No puedes curarte con la salud máxima")
        }else {
            GestionConsola.mostrarinfo("Te curas 1 de vida")
            vidas++
            println(info())
        }
    }

    override fun huir(enemigo: Enemigo) {
        GestionConsola.mostrarinfo("Intentas huir...")

        if (GestionConsola.dado()){ //si es true
            GestionConsola.mostrarinfo("Has tenido suerte y has logrado huir matando instantaneamente al enemigo",TextColors.green)
            enemigo.vidas-= 20 //lo siento pero es la unica manera que se me ocurre de cerrar el bucle sin un break
        }else{
            GestionConsola.mostrarinfo("No pudiste huir...")
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
        GestionConsola.mostrarinfo("La vida de $nombre es $vidas")
    }
}
