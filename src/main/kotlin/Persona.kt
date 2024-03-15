package org.practicatrim2

import org.practicatrim2.Armas.Atacable

interface  Persona{

     /**
      * Insultas a tu enemigo
      */
     fun insultar()

     /**
      * Muestra la informacion de tu personaje
      */
     fun info()

     /**
      * Te curas
      */
     fun curarse()

     /**
      * Tratas de huir como un cobarde
      */
     fun huir(enemigo: Enemigo?)

}
