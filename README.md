# WordsInvaders
Java FX game like space invaders but with words

## Tipo del Juego
Es un juego para aprender o practicar léxico en otros idiomas, presentado por medio de un shooter espacial.

## Razón de la Elección
Desde el punto educativo, se escoge un juego de léxico debido al alcance en varias edades que puede tener el juego, además de la facilidad para alimentar la base de datos de términos con bases de datos curadas de internet.

Desde el punto de gameplay, se escoge un shooter de naves basado en el clásico space invaders por la nostalgia que genera y es un modo de juego sencillo y altamente conocido que al cambiar un poco el estilo de juego de tener que eliminar todos los objetivos a tener que atinar a un objetivo en específico que corresponda a la palabra que se busca lo vuelve una opción sencilla de adaptar para el objetivo académico del juego.

Desde el punto de vista de programación orientada a objetos, luce como un proyecto apropiado para abarcar los conceptos claves de la programación orientada a objetos debido a la forma en que deben ser construidos los enemigos(objetivos) las diferentes representaciones que pueden tener y las interacciones que pueden tener entre sí, además que el gameplay se desarrolle en un escenario estático permite enfocarse en los conceptos que se desean desarrollar sin gastar tanto tiempo en ejecución de partes no relevantes para el proyecto y para el aprendizaje de los términos que se desea ver durante el curso.

## Descripción del Juego
Número de jugadores
Un solo jugador al tiempo.

## Mecánicas de juego

**Objetivo:** el objetivo es dispararle al elemento que represente la palabra que aparecerá a un lado de la pantalla, cada vez que el jugador le atine a la palabra correspondiente el objetivo cambiará, los elementos flotantes variarán entre imágenes o palabras, y el enemigo objetivo cambiará entre el idioma base o el idioma escogido para el juego.
No hay forma de ganar, se trata de ver que tan lejos llegue.

**Personaje principal:** El jugador controla una pequeña nave que puede disparar dos tipos de misil, uno para eliminar los objetivos erróneos y otro para eliminar el objetivo correcto.

**Misiles:** Dos tipos de misiles pueden ser usados, el rojo(por definir, pero temporalmente clic izquierdo) para eliminar enemigos que creemos que no es el objetivo correcto, y azul(por definir, temporalmente clic derecho) usado para atinarle al objetivo que creemos correcto.

**Enemigos:** los enemigos son elementos flotantes que pueden cambiar entre texto e imágenes, los enemigos se moverán aleatoriamente e irán descendiendo poco a poco, una vez el jugador logre atinarle al enemigo objetivo con el misil correcto(azul), los enemigos visibles desaparecerán de la pantalla y nuevos enemigos emergerán, si un enemigo recibe un disparo del misil rojo el enemigo automáticamente desaparecerá.
Puede haber varios enemigos objetivos al tiempo representados de diferente o de la misma manera, con solo atinarle a uno de los enemigos objetivos se eliminan los demás enemigos en pantalla(oleada).

**Nivel de dificultad:** cada vez que disparemos un misil azul a un objetivo erróneo, los enemigos comenzaran a descender con mayor velocidad(por definir factor de cambio), los enemigos bajan en bloque y es posible tener que eliminar varios enemigos de las filas delanteras para alcanzar al enemigo objetivo.
Cada vez que se logre un objetivo, el nivel de dificultad aumentará con base en la cantidad de enemigos, lo poco común de la palabra objetivo y la velocidad de descenso.
El nivel de dificultad puede ser escogido antes de empezar el juego.


**Sistema de puntos**
Más que puntos se trata de oleadas de enemigos, y se presentará cuantas oleadas se logró enfrentar antes de morir, cada oleada representa que se atinó al término objetivo.
En información se compartirá cuantos enemigos fueron eliminados con el misil incorrecto, es decir, cuantos misiles rojos golpearon a un enemigo objetivo y cuantos misiles azules golpearon a un enemigo que no era objetivo.


**Base de Datos**

Por el formato del juego se usarán bases de datos de palabras y sus traducciones curadas, encontrar la base de datos de palabras en internet es una tarea a ejecutar durante el desarrollo del proyecto, ya que se espera contar una fuente confiable.


## Diagrama de flujo
 ![diagrama de flujo de words invaders](/assets/WordsInvaders_Class_Diagram.drawio.png)

## Pendiente para entrega Final

* Completar la logica de negocio de las clases relacionadas a las palabras
* Completar tests unitarios para todas las clases
* Agregar las funcionalides de Java FX para movimiento e inputs
* Agregar assets visuales

