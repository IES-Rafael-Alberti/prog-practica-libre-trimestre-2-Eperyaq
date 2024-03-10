package org.practicatrim2

interface Atacable {

        val danio:Int
        /**
         * Disparas a tu contrincante y le bajas vida
         */
        abstract fun disparar(jugador:Jugador,danio:Int, pelea: Pelea):String // le paso la pelea para solo usarla en la escopeta


        /**
         * Recarga el arma
         */
        abstract fun recargar():String

        /**
         * Pegas con tu arma a melee
         */
        abstract fun pegarMelee(pelea: Pelea, jugador: Jugador):String

        /**
         * Informacion sobre el arma que tienes en el momento
         */
        abstract fun inspeccionar():String

}