package org.practicatrim2

interface Atacable {

        val danio:Int
        /**
         * Disparas a tu contrincante y le bajas vida
         */
        abstract fun disparar(jugador:Jugador,danio:Int):String


        /**
         * Recarga el arma
         */
        abstract fun recargar():String

        /**
         * Pegas con tu arma a melee
         */
        abstract fun pegarMelee(pelea: Pelea, jugador: Jugador):String

}