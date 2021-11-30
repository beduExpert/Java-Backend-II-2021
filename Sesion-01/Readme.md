
## :wave: Sesión 1: Introducción a Spring Framework 5 y Spring Boot 2

### 🎯 Objetivo de la sesión:
- Entender qué es Spring Framework y la diferencia con Spring Boot.
- Hacer uso de Spring Initializr para la creación de un nuevo proyecto con Spring Boot 5.
- Compilar y ejecutar el proyecto usando Gradle desde la línea de comandos.
- Compilar y ejecutar el proyecto usando Maven desde la línea de comandos.
- Aprender a crear el proyecto desde el IDE IntelliJ Idea para compilarlo y ejecutarlo.


## Introducción

En la actualidad el desarrollo de aplicaciones empresariales, aunque es más sencillo ya que hay muchas herramientas, APIs, y Frameworks; también, se vuelve un poco más complicado porque nuestras aplicaciones deben ser capaces de conectarse con otras aplicaciones y servicios. Además, como desarrolladores, somos los responsables de coordinar cada una de las partes de nuestra aplicación para que todo funcione correctamente.

También, debemos tomar en cuenta darle mantenimiento a nuestras aplicaciones, y que en algunos casos será necesario que cambiemos módulos o capas enteras de la misma para mejorarla; como por ejemplo sustituir JDBC con Hibernate en los casos en los que sea prudente.

Afortunadamente existen super-frameworks que nos ayudan haciéndose cargo de todas o casi todas las “complicaciones” mencionadas anteriormente. Spring es el más popular de estos super-frameworks Java. 

Desde sus inicios Spring se ha convertido en un estándar de facto para construir aplicaciones empresariales en Java y actualmente es uno de los frameworks más maduros de la industria. Este estándar brinda la base para la definición y el trabajo de los grupos de programadores a nivel empresarial, definiendo los fundamentos necesarios para desarrollar aplicaciones usando otras tecnologías que interactúan con Spring como servidores contenedores, bases de datos accedidas por JDBC, Hibernate o JPA, interfaces usando MVC y servicios Web y REST, mensajes sincrónicos y asincrónicos como también seguridad con foco en el correcto uso de APIs dentro del marco de trabajo y su correcta implementación. 

Spring es un framework muy ligero que proporciona muchos de los elementos de infraestructura que las aplicaciones modernas necesitan. Eso quiere decir que Spring maneja esos aspectos de infraestructura y nosotros solo debemos preocuparnos por implementar la lógica de la aplicación.

También, Spring fue diseñado de forma modular, esto significa que puedes usar solo las partes que necesitas.


![Modulos de Spring](/images/1.png)

Spring está diseñado para no ser intrusivo, esto significa que no es necesario que nuestra aplicación extienda o implemente alguna clase o interface de Spring (si no lo queremos), por lo que nuestro código de lógica quedará libre y completamente reutilizable para un proyecto sin Spring.

Además, si usamos Spring de la forma correcta (lo cual no es difícil) nuestra aplicación quedará dividida en capas bien delimitadas, y con buenas prácticas de programación.

El núcleo de Spring está basado en un principio o patrón de diseño llamado Inversión de Control (IoC por sus siglas en inglés). Las aplicaciones que usan el principio de IoC se basan en su configuración (que en este caso puede ser en archivos XML o con anotaciones como en Hibernate) para describir las dependencias entre sus componentes, esto es, los otros objetos con los que interactúa. En este caso “inversión” significa que la aplicación no controla su estructura; permite que sea el framework de IoC (en este caso Spring) quien lo haga.

Spring también cuenta con un gran número de extensiones, llamados proyectos, las cuales brindan elementos funcionales adicionales a los de su core, como seguridad, procesamiento de información por lotes, creación y consumo de servicios web, etc.

![Otros proyectos de Spring](/images/2.png)

Spring Boot es una extensión de Spring framework que permite eliminar la mayor parte del trabajo de las configuraciones básicas de Spring. Es una de esas maravillas dentro de la maravilla que ya es Spring; literalmente en unos pocos segundos se puede tener una aplicación web recibiendo peticiones y lista para desplegarse, ya que contiene un conjunto inteligente de valores por default. Esto hace que requiera muy poca o ninguna configuración, y esa poca configuración se da en forma de anotaciones. No por nada ha sido una de las herramientas más utilizadas por la comunidad de Spring desde su aparición en 2013.


![diferencias entre Spring y Spring Boot](/images/3.png)


Una aplicación Spring Boot se ejecuta igual que una aplicación Java "normal", no es necesario colocarla en algún contenedor o servidor para que se ejecute, y esto es porque las aplicaciones Spring Boot ya tienen un servidor embebido. El servidor que se use por default dependerá de la versión de Spring Boot que estemos usando; en este caso es un Tomcat embebido, pero en versiones anteriores se usaba Netty.

Además del servidor, Spring Boot integra todas las dependencias que necesita para funcionar dentro de un Uber Jar (del cual hablaremos más a detalle más adelante).

Para poder manejar todo este conjunto de dependencias de una manera sencilla, Spring Boot integra algo que se llaman "starters", que es una especie de paquetes virtuales que no contienen código, sino una lista de las dependencias que necesita para funcionar.
org.springframework.boot:spring-boot-starter-web
org.springframework.boot:spring-boot-starter-test
Estos son los starters para web y para pruebas, pero existen literalmente decenas de starters dependiendo de las dependencias que hayamos seleccionado. Algunos de los starters que podríamos usar son, por ejemplo:
spring-boot-starter-thymeleaf
spring-boot-starter-data-mongodb-reactive
spring-boot-starter-webflux


Gracias a esto, el lograr que una aplicación web funcione es tan sencillo como crear el siguiente código.



@SpringBootApplication
public class MiAplicacionWeb{

    public static void main(String[] args) {
        SpringApplication.run(AplicacionWeb.class, args);
    }
 
}


Como vemos, esta clase está decorada con la anotacicón "@SpringBootApplication" y sólo tiene un método main que manda llamar un método estático "SpringApplication.run". A continuación, una explicación de estos elementos:

La anotación "@SpringBootApplication" le dice a Spring Boot que cuando se lance la clase, debe escanear recursivamente por componentes de Spring dentro del paquete en el que se encuentra la clase y que los registre en el contexto de Spring. También indica que se debe habilitar la autoconfiguración, que es un proceso donde se crean ciertos beans de forma automática basado en ciertas clases encontradas en el classpath, valores en archivos de propiedades, y otros factores. Finalmente, indica que esta clase es una fuente de definiciones de beans de Spring.
SpringApplication.run le indica a Spring Boot cuál clase es el punto inicial de la aplicación. En este caso es la misma clase pero podría ser alguna otra.



A partir de aquí ya podemos ejecutar nuestra aplicación haciendo clic en el botón “Run” que se encuentra en la parte superior derecha del editor.

![Modulos de Spring](/images/4.png)


Con cualquiera de las dos opciones comenzará la ejecución de nuestra aplicación y deberemos ver una salida muy similar a la siguiente en la consola:

![imagen](/images/5.png)


En la salida es importante destacar los siguientes elementos:

![imagen](/images/6.png)


El banner superior nos indica que la aplicación se inició y qué versión de Spring Boot se está utilizando. Este banner se puede cambiar poniendo un archivo llamado "banner.txt" o "banner.png" con el contenido que queramos que aparezca; este archivo debe ponerse en el directorio "src/main/resources".
El Tomcat embebido se inició en el puerto 8080.
Se indica el tiempo que tomó la aplicación en iniciar, en la imagen anterior son 26.458 segundos.
Ahora podemos ir a nuestro navegador y colocar la siguiente dirección:

http://localhost:8080

Con lo que debemos ver una pantalla como la siguiente:

![imagen](/images/7.png)


Aunque la pantalla anterior es de un error, no debes preocuparte ya que este error quiere decir que no hay ningún recurso o página que apunte a la URL base del proyecto ("/"); si nos fijamos bien la página nos dice que se trata de un error 404 (Not found), esto es porque, aunque ya tenemos nuestra aplicación esta continúa estando vacía.

Lo que es importante resaltar aquí es que sin mayor esfuerzo tenemos una aplicación que se ejecuta en un tomcat embebido y no hemos tenido que escribir ni una sola línea de configuración o código. 



### Ejemplos y Retos

- Creación de proyecto Gradle con Spring Initializr
    - [Ejemplo 01](Ejemplo-01)
    - [Reto 01](Reto-01)
 
- Creación de proyecto Maven con Spring Initializr
    - [Ejemplo 02](Ejemplo-02)
    - [Reto 02](Reto-02)

- Creación de proyecto Maven con IntelliJ Idea
    - [Ejemplo 03](Ejemplo-03)
    - [Reto 03](Reto-03)
