package org.practicatrim2.Armas

import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

interface Atacable {

        val danio:Int
        /**
         * Disparas a tu contrincante y le bajas vida
         */
        abstract fun disparar(jugador: Jugador, danio:Int, pelea: Pelea) // le paso la pelea para solo usarla en la escopeta


        /**
         * Recarga el arma
         */
        abstract fun recargar()

        /**
         * Pegas con tu arma a melee
         */
        abstract fun pegarMelee(pelea: Pelea, jugador: Jugador)

        /**
         * Informacion sobre el arma que tienes en el momento
         */
        abstract fun inspeccionar()

}