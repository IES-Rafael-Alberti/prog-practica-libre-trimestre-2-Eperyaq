package org.practicatrim2

object GestionConsola {
    fun preguntarnum():Int{
        var numero= 0
        try {
             numero = readln().toInt()
        }catch (e: NumberFormatException){
            println("Inserte un numero válido")
        }
        return numero
    }


}