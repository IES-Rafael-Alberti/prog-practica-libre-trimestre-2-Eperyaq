package org.practicatrim2

import org.practicatrim2.Armas.Atacable

interface  Persona{

    abstract fun insultar()

    abstract fun seguir_camino()


    abstract fun info()

    abstract  fun acortarDistancia(pelea: Pelea)

    abstract fun curarse()

    abstract fun huir()

    abstract fun morir()


}
