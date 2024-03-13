package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

interface Atacable {

        val danio:Int
        /**
         * Disparas a tu contrincante y le bajas vida
         */
        fun disparar(jugador: Jugador, pelea: Pelea, atacable: Atacable):Int  // le paso la pelea para solo usarla en la escopeta, retorna un entero que es el daño que hace


        /**
         * Recarga el arma
         */
        fun recargar()

        /**
         * Pegas con tu arma a melee
         */
        fun pegarMelee(pelea: Pelea, jugador: Jugador, npc:Enemigo)

        /**
         * Informacion sobre el arma que tienes en el momento
         */
        fun inspeccionar()


        fun comprobarMuncion():Boolean

}