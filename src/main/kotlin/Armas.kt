package org.practicatrim2


//cuando cree las clases escopeta meter unas balas maximas a la hora de recargar
abstract  class Armas(var arma: TipoArma, val tipomunicion:String, var cantidadMunicion:Int = 10 ) {
    /**
     * Disparas a tu contrincante y le bajas vida
     */
    abstract fun disparar(jugador:Jugador,danio:Int):String


    /**
     * Indica el daño que realiza el arma
     */
    abstract fun danioArmas(): Int


    /**
     * Recarga el arma
     */
    abstract fun recargar():String






}
