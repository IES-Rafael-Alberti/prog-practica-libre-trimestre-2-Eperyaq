package org.practicatrim2

class PalodeGomaEspuma(val arma: TipoArma, val tipomunicion:String, var cantidadMunicion:Int, private val municionTope: Int = 5):Atacable {
    override var danio = 4

    /**
     * Disparas...
     *
     *@param jugador Jugador al que seguro que le haces gracia
     *
     *@return algo muy guapo
     */
    override fun disparar(jugador:Jugador,danio:Int, pelea: Pelea):String{
        return "Mmmm, que disparas? rayos laser?"
    }

    /**
     * Recargas...
     *
     * @return String graciosete
     */
    override fun recargar(): String {
        return "Que pretendes recargar?"
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

    override fun inspeccionar():String{
        return "Tu arma actual es un $arma, y... no se que mas quieres saber la verdad"
    }
}
