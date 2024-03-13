package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.GestionConsola
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

class Cuchillo(var cantidadCuchillos:Int): Atacable {
    override val danio = 2


    companion object{
        private val cuchillosRespuesto: Int = 5 // la cantidad de cuchillos máxima que puede tener
    }
    /**
     * Lanzas un cuchillo contra tu oponente y le bajas la vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del [jugador]
     */
    override fun disparar(jugador: Jugador, pelea: Pelea, atacable: Atacable):Int {
        println("Lanzas tu ${TipoArma.CUCHILLO.desc} e inflinges $danio")
        cantidadCuchillos--
        return danio
    }

    /**
     * PRINCIPIO TREMENDAMENTE SOLIDO
     * Comprueba si el arma tiene municion suficiente como para disparar
     */
    override fun comprobarMuncion():Boolean{
        if (cantidadCuchillos >0)
            return true
        else {
            println("No tienes suficientes cuchillos")
            return false
        }
    }

    /**
     * Recargas tus cuchillos
     *
     * @return String indicando cuantas cuchillos has recargado
     */
    override fun recargar() {
        cantidadCuchillos = cuchillosRespuesto
        println("Recargas tu ${TipoArma.CUCHILLO.desc} y ahora tienes $cantidadCuchillos Cuchillos más")
    }

    /**
     * Pegas navajazo a corta distancia que hace bastante daño, si no estas dentro del rango, fallas
     *
     */
    override fun pegarMelee(pelea: Pelea, jugador: Jugador, npc:Enemigo){
        if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 5 de vida")
            jugador.vidas -= 5
            jugador.info()
        }else{
            println("No llegas y por tanto no haces daño")
        }
    }

    override fun inspeccionar(){
        println("Tienes un ${TipoArma.CUCHILLO.desc}, tus chuchillos actuales son $cantidadCuchillos y los de repuesto son $cuchillosRespuesto")
    }
}
