package org.practicatrim2

class Escopeta(arma: TipoArma, tipomunicion:String, cantidadMunicion:Int, val municionTope: Int = 2 ):Armas(arma, tipomunicion, cantidadMunicion) {
    /**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param jugador Jugador al que bajarle la vida
     *
     *@return Informacion acerca de los datos del jugador
     */
    override fun disparar(jugador:Jugador,daño:Int):String{
        println("Disparas tu $arma e inflinges $daño")
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


    override fun recargar():String { //estaria bien preguntar cuantos quiere recargar pero en esta clase no vale para nada porque no creo que quieras recargar 1 solo
        cantidadMunicion = municionTope


        return "Recargas tu $arma con $municionTope balas"
    }
}
