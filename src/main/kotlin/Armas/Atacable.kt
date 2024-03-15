package org.practicatrim2.Armas

import org.practicatrim2.Enemigo
import org.practicatrim2.Jugador
import org.practicatrim2.Pelea

interface Atacable {

        val danio:Int
        /**
         * Disparas al npc  y le bajas vida RECIBE DAÑO EL NPC
         */
        fun disparaJugador(npc: Enemigo?, pelea: Pelea, atacable: Atacable)  // le paso la pelea para solo usarla en la escopeta, retorna un entero que es el daño que hace


        /**
         * Disparas al jugador y le bajas vida, RECIBE DAÑO EL JUGADOR
         */
        fun disparaNpc(jugador: Jugador, pelea: Pelea, atacable: Atacable)

        /**
         * Recarga el arma
         */
        fun recargar()

        /**
         * Pegas con tu arma a melee
         */
        fun pegarMelee(pelea: Pelea, npc:Enemigo?)

        /**
         * Informacion sobre el arma que tienes en el momento
         */
        fun inspeccionar()

        /**
         * Comprueba si tiene municion para hacer otras cosas
         */
        fun comprobarMuncion():Boolean

}