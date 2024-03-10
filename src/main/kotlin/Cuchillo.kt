package org.practicatrim2

class Cuchillo(val arma: TipoArma, var cantidadCuchillos:Int, private val cuchillosRespuesto: Int = 5):Atacable {
    override val danio = 2
    /**
     * Lanzas un cuchillo contra tu oponente y le bajas la vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador:Jugador,danio:Int, pelea: Pelea):String{
        if (cantidadCuchillos >0)
            println("Disparas tu $arma e inflinges $danio")
        cantidadCuchillos--
        jugador.vidas -= danio


        return jugador.info()
    }

    /**
     * Recargas tus cuchillos
     *
     * @return String indicando cuantas cuchillos has recargado
     */
    override fun recargar(): String {
        cantidadCuchillos = cuchillosRespuesto
        return "Recargas tu $arma y ahora tienes $cantidadCuchillos Cuchillos más"
    }

    /**
     * Pegas navajazo a corta distancia que hace bastante daño, si no estas dentro del rango, fallas
     *
     */
    override fun pegarMelee(pelea:Pelea, jugador: Jugador): String {
        return if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 5 de vida")
            jugador.vidas -= 5
            jugador.info()
        }else{
            "No llegas y por tanto no haces daño"
        }
    }

    override fun inspeccionar(): String {
        return "Tienes un $arma, tus chuchillos actuales son $cantidadCuchillos y los de repuesto son $cuchillosRespuesto"
    }
}
