package org.practicatrim2

class Revolver(arma: TipoArma, tipomunicion:String, cantidadMunicion:Int, private val municionTope: Int = 6):Armas(arma, tipomunicion, cantidadMunicion) {
    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador:Jugador,danio:Int):String{
        println("Disparas tu $arma e inflinges $danio")
        cantidadMunicion--
        jugador.vidas - danioArmas()


        return jugador.info()
    }


    /**
     * Indica el daño que realiza el arma
     *
     * @return daño el daño que realiza tu arma
     *
     */
    override fun danioArmas(): Int{
        var danio = 0
        danio = when (arma){
            TipoArma.EscopetaLargaDistancia -> 4
            TipoArma.Escopeta -> 2
            TipoArma.Revolver -> 2
            TipoArma.Cuchillo -> 1
            TipoArma.palo_GomaEspuma -> 0
        }
        return danio
    }


    override fun recargar():String {

        println("Cuantas balas quieres recargar, maximo $municionTope")
        val municionARecargar:Int = readln().toInt()
        if (municionARecargar >0){
            cantidadMunicion = municionARecargar
            return "Recargas tu $arma con $municionARecargar balas"


        }else {
            cantidadMunicion = municionTope
            return "Recargas tu $arma con $municionTope balas"
        }
    }
}
