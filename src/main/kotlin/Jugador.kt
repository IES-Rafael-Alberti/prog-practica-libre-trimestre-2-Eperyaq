package org.practicatrim2

class Jugador(val nombre:String,val arma: TipoArma,val vidas:Int):Persona {


    override fun seguir_camino(): String {
        return "Sigues tu camino..."
    }


    override fun insultar():String {
        return "$!#*€"
    }


    override fun info():String{
        return "$nombre tiene de arma $arma y le quedan $vidas vidas."
    }
}
