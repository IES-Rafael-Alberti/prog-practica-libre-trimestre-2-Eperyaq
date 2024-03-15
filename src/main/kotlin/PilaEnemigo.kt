package org.practicatrim2

import kotlin.random.Random

class PilaEnemigo {
    private val pila = mutableListOf<Enemigo>()

    /**
     * Agrega un enemigo a la pila
     * @param npc Enemigo que se va a añadir a la pila
     */
    fun push(npc: Enemigo) {
        pila.add(npc)
    }

    /**
     * Saca un enemigo de la Pila
     */
    fun pop(): Enemigo? {
        if (isEmpty()) {
            return null
        }
        val enemigoRandom = Random.nextInt(0, pila.size) //Saca un enemigo random con el rango (0 - tamaño de la pila)

        return pila.removeAt(enemigoRandom)
    }

    /**
     * Comprueba si la pila esta vacia, si lo está retorna true
     * @return Estado de la pila, si es true, está vacía si no, tiene algo dentro
     */
     fun isEmpty(): Boolean {
        return pila.isEmpty()
    }

}
