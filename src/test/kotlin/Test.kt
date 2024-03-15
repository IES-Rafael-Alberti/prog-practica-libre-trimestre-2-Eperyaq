import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.practicatrim2.Armas.Cuchillo
import org.practicatrim2.GestionConsola

class PruebaFuncion {

    @Test
    fun comprobarMuncion(){
        //Creamos una instancia de la clase
        val cuchillito = Cuchillo(5)
        cuchillito.cantidadCuchillos = 1 // Asignamos una cantidad de cuchillos suficiente para que de true siempre

        //llamamos a la funcion para probar que sirve
        val resultado = cuchillito.comprobarMuncion()

        // Comprobamos que sirve con un assert true
        assertTrue(resultado)
    }

    @Test
    fun comprobarMuncion2() { //Comprueba si no tienes cuchillos
        // Creamos una instancia de la clase
        val  cuchillito= Cuchillo(5)
        cuchillito.cantidadCuchillos = 0 // Asignamos una cantidad de cuchillos insuficiente para que de false siempre

        // Llamamos a la funcion para comprobar que sirva
        val resultado = cuchillito.comprobarMuncion()

        //mostramos un string ya que la funcion lo hace y si no lo hacemos no lo comprueba todoo

        GestionConsola.mostrarinfo("No tienes balas")
        assertFalse(resultado) //Usamos el assertFalse

        //No entiendo el desplegable que sale pero me comprueba la funcion y funciona bien :D

    }


}