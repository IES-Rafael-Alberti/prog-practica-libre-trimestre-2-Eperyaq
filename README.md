[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/mnkKwimk)
# Actividad: Desarrollo de Proyecto Software en Kotlin

**ID actividad:** 2324_PRO_u4u5u6_libre

**Agrupamiento de la actividad**: Individual 

---

### Descripción:

La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.

**Objetivo:**

- Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos.
- Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces.
- Crear y usar clases que hagan uso de genéricos. 
- Aplicar principios SOLID.
- Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto.
- Documentar y presentar el código de manera clara y comprensible.

**Trabajo a realizar:**

1. **Selección de la Temática:** Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.

2. **Planificación:** Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.

3. **Desarrollo:**
   - **Instancia de Objetos:** Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades.
   - **Métodos Estáticos:** Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación.
   - **Uso de IDE:** Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código.
   - **Definición de Clases:** Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores.
   - **Clases con genéricos:** Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación.
   - **Herencia y Polimorfismo:** Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño.  **Usa los principios SOLID:** Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación.
   - **Librerías de Clases:** Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación.
   - **Documentación:** Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento.

4. **Prueba y Depuración:** Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
5. **Contesta a las preguntas** ver el punto **Preguntas para la Evaluación**

### Recursos

- Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías.
- Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías.

### Evaluación y calificación

**RA y CE evaluados**: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.

**Conlleva presentación**: SI

**Rubrica**: Mas adelante se mostrará la rubrica.

### Entrega

> **La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.**
>
- **Conlleva la entrega de URL a repositorio:** El contenido se entregará en un repositorio GitHub. 
- **Respuestas a las preguntas:** Deben contestarse en este fichero, README.md


# Preguntas para la Evaluación

Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, **asegúrate de hacer referencia y enlazar al código relevante** en tu `README.md`, facilitando así la evaluación de tu trabajo.

#### **Criterio global 1: Instancia objetos y hacer uso de ellos**
- **(2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a)**: Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.
*** 
Para instanciar un objeto lo primero que he hecho ha sido crear una clase de la que poder instanciar, le he puesto sus parámetros al constructor primario y despues desde el Main he hecho una referencia a esa clase, pasandole todos los datos necesarios para que se instancie la clase

Siendo esta la clase:
~~~
class Enemigo(val nombre:String, val arma:Atacable, var vidas:Int)
~~~
Y esta la instancia: 
~~~
val npc3 = Enemigo("David El Mataescorias",listaArmasDCS,10)
~~~
Para pasarle los parámetros a los métodos he hecho algo parecido, simplemente le paso por el constructor lo que necesita y me aseguro de que la clase que contiene ese metodo tenga los valores necesarios para que funcione el método    

En el caso de los métodos, Si necesito algo que tiene otra funcion u otro método, me aseguro de pasarle por parámetros todo lo que necesite, por ejemplo, aqui esta el método principal
~~~
 /**
     * Recibes el daño del ataque
     * @param [dañoRecibido], la vida que le baja al personaje
     */
    fun recibirDaño(dañoRecibido:Int){
        vidas -= dañoRecibido
        GestionConsola.mostrarinfo("La vida de $nombre es $vidas")
    }
  ~~~
Y aquí tengo la funcion o clase de la que necesita coger los parámetros necesarios, De está cojo el daño para usarlo en el método de arriba
~~~
/**
     * Disparas a tu contrincante y le bajas vida
     *@param npc  al que bajarle la vida
     *@param pelea en la que estas involucrado
     *@param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?,pelea: Pelea,atacable: Atacable){
        GestionConsola.mostrarinfo("Disparas tu ${TipoArma.ESCOPETALARGADISTANCIA.desc} e inflinges $danio de vida")
        cantidadMunicion--
        npc?.recibirDaño(danio)
    }
~~~

***
#### **Criterio global 2: Crear y llamar métodos estáticos**
- **(4.i)**: ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?  
  
He definido un método estático en la clase ***Pelea*** y lo he usado para que, cada vez que se llame a esta clase, el valor de mi método estático sea distinto ya que he implementado un random en este.
~~~
companion object {
        var distancia = Random.nextInt(1, 10)
    }
~~~
***
- **(2.e)**: ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?
  
En mi código se usa en varias partes, por ejemplo en mi clase ***Escopeta*** Dependiendo de la distancia que haya entre los jugadores esta hace más o menos daño

~~~
/**
     * Disparas a tu contrincante y le bajas vida
     *
     * @param npc npc al que bajarle la vida
     * @param pelea en la que estas involucrado
     * @param atacable arma que estas utilizando
     */
    override fun disparaJugador(npc: Enemigo?,pelea: Pelea,atacable: Atacable){

        if (pelea.mostrarDistancia() < 6){ //segun lo cerca que estén la escopeta hará mas o menos daño
            this.danio = 3
        }else if (pelea.mostrarDistancia() < 4){
            this.danio = 4
        }
        else if (pelea.mostrarDistancia() <2){
            this.danio = 5
        }else{
            this.danio = 2
        }

        GestionConsola.mostrarinfo("Disparas con tu ${TipoArma.ESCOPETA.desc} e inflinges $danio de vida")
        cantidadMunicion--
        npc?.recibirDaño(danio)

    }
~~~

#### **Criterio global 3: Uso de entornos**
- **(2.i)**: ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa.  
1. Primero cree un nuevo proyecto escogiendo la opcion de hacerlo a traves del controlador de versiones
2. Copie y pegue el enlace del repositorio de github classroom
3. Una vez clonado el proyecto me hice un pequeño esquema y de ahi empecé a utilizar el IDE creando las clases, metodos etc
4. He probado el codigo depurando y me gustaría implementarle una prueba unitaria con la libreria Junit.

#### **Criterio global 4: Definir clases y su contenido**
- **(4.b, 4.c, 4.d, 4.g)**: Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda?
  
A la hora de definir las clases lo que hice fué basarme en un esquema creado por mi, en un principio tenía una vaga idea de que quería un juego que fuese inspirado en el antiguo oeste con duelos de pistoleros.   
De ahi fue amoldando la idea, creando la clase de las armas, los parámetros necesarios y reales para estos como las balas que tiene, las balas mácimas que caben en el cargador etc.  

Para identificarlo en mi caso fue facil porque, ¿Qué necesita un arma para disparar? Municion y realizar un daño después de haber disparado.  
Para saber si algunas propiedades tenían que ser privadas o no solo necesitaba preguntarme algo ¿Alguna otra clase totalmente ajena de esta lo va a necesitar? Y en algunos casos si, para hacer comprobaciones  pero en muchos otros no, por eso hay algunos parámetros que los tengo privados
~~~
class Revolver(var cantidadMunicion:Int, private val municionTope: Int = 6):
~~~
En este caso, para que querria cualquier otra clase saber cuanta municion me cabe como máximo en la clase revolver?   
En cambio la cantidad de municion si la tenia que dejar 'abierta' para que métodos de otras clases pudieran acceder a ella para comprobar algo como por ejemplo en mi Object ***GestionConsola*** antes de disparar, compruebo si tengo balas y para eso necesito ver la cantidad de municion que tiene el arma en ese momento, y respondiendo de nuevo a la pregunta anterior, le tengo que pasar por parámetros el arma para poder acceder a esta y que asi este método pueda usarse de manera efectiva.
~~~
/**
     * Opciones de la pelea del npc
     * @param jugador Jugador principal, lo necesitamos para las otras funciones de esta
     * @param npc Enemigo principal que en este caso es el que va a realizar el ataque
     * @param atacable Arma con la que te va a atacar el npc
     * @param pelea Pelea que estais teniendo
     */
    fun opcionesPeleaNpc( jugador: Jugador, npc: Enemigo?, atacable: Atacable, pelea: Pelea ) {
        mostrarinfo("1. Disparar")
        mostrarinfo("2. Curarse")
        mostrarinfo("3. Recargar")

        val opcion = npc?.desicionRandom(atacable)
        when (opcion){
            1-> if (npc.arma.comprobarMuncion()) {
                npc.arma.disparaNpc(jugador, pelea, atacable)
            }else{
                opcionesPeleaNpc(jugador,npc,atacable,pelea)
            }
            2-> npc.curarse()
            3-> npc.arma.recargar()
        }
    }
~~~
#### **Criterio global 5: Herencia y uso de clases abstractas e interfaces**
- **(4.h, 4.j, 7.a, 7.b, 7.c)**: Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido?
### Herencia / Interfaces:
El uso de los interfaces en mi proyecto ha sido para la facilidad que esta ofrece.  
He creado un interfaz ***atacable*** que es como crear una plantilla para todas las armas y que todas las armas que hereden de esa interfaz van a tener minimo implementados un número de métodos mínimos que usaría un arma real
~~~
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
~~~
Elegí usar una interfaz porque es una manera muy sencilla de crear una plantilla para un objeto real que use mínimo los métodos que yo implemente en el interfaz.

### Principios Solid:
Para cumplir los Principios Solid he podido implementar el principio ***SRP (Single Responsability Principle)*** el cual se basa en comprobar que tus clases solo hagan una cosa, y en mi caso, en un principio mis armas disparaban, controlaban el daño, y hacían que el jugador enemigo recibiese el daño, pero al darme cuenta de que estaba incumpliendo ese principio SOLID decidí quitarle cosas a la clase y controlarlas desde otro lugar.   
Ahora controlo el daño recibido desde otra clase y asi es más sencillo por si quiero cambiar algo de esta y no me influye en cambiar toda la clase del arma


#### **Criterio global 6: Diseño de jerarquía de clases**
- **(7.d, 7.e, 7.f, 7.g)**: Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción?
  
He usado un tipo de herencia en especializacion donde algunas clases son tipos especificos de la clase base.  
A la hora de comprobar su correcto funcionamiento, a medida que iba haciendo el programa iba probando algunas funciones que pensaba que podrían dar problemas y si lo daban lo arreglaba
#### **Criterio global 7: Librerías de clases**
- **(2.g, 4.k)**: Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto.  

Implementé la librería de ***Mordant*** la cual me ayuda a que la interfaz de mi proyecto sea más bonita y visual, ya que no es lo mismo ver todo en el color gris de la consola que verlo con colores que es más atractivo y menos aburrido a la vista.  
Lo usé en casi todos de los String que tengo para que haga el juego más bonito.

#### **Criterio global 8: Documentado**
- **(7.h)**: Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código?

#### **Criterio global 9: Genéricos**
- **(6.f)**: Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido?

