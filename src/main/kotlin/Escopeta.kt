package org.practicatrim2

class Escopeta(val arma: TipoArma, val tipomunicion:String, var cantidadMunicion:Int, private val municionTope: Int = 6):Atacable {
    override val danio = 2
    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador:Jugador,danio:Int):String{
        if (cantidadMunicion >0)
            println("Disparas tu $arma e inflinges $danio")
        cantidadMunicion--
        jugador.vidas -= danio


        return jugador.info()
    }

    /**
     * Recargas tu arma al tope permitido por el cargador siempre
     *
     * @return String indicando cuantas balas has recargado
     */
    override fun recargar(): String {
        cantidadMunicion = municionTope
        return "Recargas tu $arma con $municionTope balas"
    }

    /**
     * Pegas un golpe a una distancia corta, si estas desde lejos no puedes pegar
     *
     */
    override fun pegarMelee(pelea:Pelea, jugador: Jugador): String {
        return if (pelea.distancia <=1){
            println("Le pegas a melee al enemigo y le quitas 1 de vida")
            jugador.vidas--
            jugador.info()
        }else{
            "No llegas y por tanto no haces daño"
        }
    }
}
