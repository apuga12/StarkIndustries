
<html>
  <head><title> ::: Spring App 3.2.1 :::</title></head>
  <body>
    <h3>  ::: Spring App 3.2.1 :::</h3>
    <p>Tony Stark is in the house :)</p>
    
    <h2>Desarrollando una aplicación Spring Framework MVC v3 + JPA paso a paso </h2>
    <p> <a href="http://www.uv.es/grimo/teaching/SpringMVCv3PasoAPaso/">http://www.uv.es/grimo/teaching/SpringMVCv3PasoAPaso/</a>  
   
    <p> BUSCAR Jars y dependencias Maven:
    <br> <a href="https://mvnrepository.com/artifact/org.jvnet.jax-ws-commons.spring/jaxws-spring/1.9">
    		https://mvnrepository.com/artifact/org.jvnet.jax-ws-commons.spring/jaxws-spring/1.9
    </a> 
     </p>
     
     <p> Intro Axis2 = JAX-WS, POJO, Spring integration :
    <br> <a href="https://axis.apache.org/axis2/java/core/docs/jaxws-guide.html" >https://axis.apache.org/axis2/java/core/docs/jaxws-guide.html</a>
     </p>
     
     <p> SOAP Web Services with Spring MVC Framework in Eclipse :
     <br> Exponer servicios / consumirlos... 
     <br> <a href="https://www.youtube.com/watch?v=cxf0toqlvbg" >https://www.youtube.com/watch?v=cxf0toqlvbg</a>
     </p>
     
     <p> Iniciando con Spring Boot ==> Gradle (QuickStart) 
     <br> <a href="https://www.youtube.com/watch?v=p8AdyMlpmPk">https://www.youtube.com/watch?v=p8AdyMlpmPk</a>
     
     <p> Iniciando con Spring Boot ==> Gradle (BUENISIMO Aprender a detalle en dos partes) 
     <br> <a href="https://www.youtube.com/watch?v=aSGSQ8AQ9FI&t=4129s">https://www.youtube.com/watch?v=aSGSQ8AQ9FI&t=4129s</a>
     <br> Repositorio de proyectos de la clase:
     <br> <a href="https://github.com/joedayz/spring-boot-samples/blob/master/bootangular/">
     	https://github.com/joedayz/spring-boot-samples/blob/master/bootangular/src/main/webapp/WEB-INF/jsp/UserManagement.jsp
     </a>
        
     
      <p> Building Java Web Services with JAX-WS:
     <br> Exponer micro servicios / consumirlos (servidores tomcat independientes)... 
      <br> Solo se requiere interface, clase impl y un main que publique los servicios.
      <br> Servicios mas veloces, mejora en el performance, pero dificil administración: Se requiere uso de un registry, 
      <br> para puertos, balanceadores, alta disponibilidad, etc.
     <br> <a href="https://www.youtube.com/watch?v=XFWoHayjMnE" >https://www.youtube.com/watch?v=XFWoHayjMnE</a>
     </p>
     
    
    <p>REPOSITORIO LOCAL MAVEN:
    <br> C:\Users\apuga\.m2\repository\javax\xml\rpc\com.springsource.javax.xml.rpc\1.1.0\com.springsource.javax.xml.rpc-1.1.0.jar
    </p>
    
    
    <br> Utilizaremos Maven2 para facilitar la creación de la estructura de directorios del proyecto así como 
    la inclusión de las librerías necesarias.
    
    <br> Crear un proyecto tipo Maven2:
    <br> Debemos seleccionar el arquetipo del proyecto. 
    <br> Los arquetipos son patrones o modelos genéricos a partir de los cuales se pueden crear proyectos de un determinado tipo. 
    <br> Maven proporciona un conjunto de estructuras de proyectos (esto es, el árbol de directorios, archivos que 
    <br> aparecerán en el proyecto, etc.) entre los cuales podemos elegir. 
    <br> De acuerdo con la naturaleza del proyecto, debemos seleccionar el arquetipo 'maven-archetype-webapp'.
    <br>
    <br> A continuación, crearemos las siguientes dependencias para el proyecto desde la pestaña 'Dependencies' del archivo 'pom.xml'. 
    <br> Las librerías seran descargadas y añadidas automáticamente al proyecto en el momento en el que guardemos el fichero 'pom.xml'
    
     <p>Capítulo 3. Desarrollando la Lógica de Negocio</p>

	 <p> Ésta es la Parte 3 del tutorial paso a paso para desarrollar una aplicación Spring MVC. <br>
	 En esta sección, adoptaremos un acercamiento pragmático al Test-Driven Development (TDD o Desarrollo Conducido por Tests) 
	 para crear los objetos de dominio e implementar la lógica de negocio para nuestro sistema de mantenimiento de inventario. <br>
	 Esto significa que "escribiremos un poco de código, lo testearemos, escribiremos un poco más de código, lo volveremos a testear...
	 " En la Parte 1 hemos configurado el entorno y montado la aplicación básica. 
	 En la Parte 2 hemos refinado la aplicación desacoplando la vista del controlador.<br><br>
	
	 Spring permite hacer las cosas simples fáciles y las difíciles posibles. 
	 La estructura fundamental que hace esto posible es el uso de Plain Old Java Objects (POJOs u Objetos Normales Java) por Spring. <br> 
	 Los POJOs son esencialmente clases nomales Java libres de cualquier contrato 
	 (normalmente impuesto por un framework o arquitectura a traves de subclases o de la implementación de interfaces). 
	 <br>Los POJOs son objetos normales Java que están libres de dichas obligaciones, haciendo la programación orientada 
	 a objetos posible de nuevo. <br>
	 Cuando trabajes con Spring, los objetos de dominio y los servicios que implementes seran POJOs. 
	 De hecho, casi todo lo que implementes debería ser un POJO. 
	 Si no es así, deberías preguntarte a ti mismo porqué no ocurre esto. <br>
	 En esta sección, comenzaremos a ver la simplicidad y potencia de Spring.
	 
	 <br><br>No hemos escrito ni una sola linea de código de Spring. 
	 <br>Éste es un ejemplo de lo no-intrusivo que es realmente Spring Framework. 
	 <br>Uno de sus propósitos principales es permitir a los programadores centrarse en la parte más importante de todas: 
	 <br>modelar e implementar requerimientos de negocio. 
	 <br>Otro de sus propósitos es hacer seguir las mejores prácticas de programación de una manera sencilla, 
	 <br>como por ejemplo implementar servicios usando interfaces y usar tests unitarios más allá de las obligaciones 
	 <br>prágmaticas de un proyecto dado. A lo largo de este tutorial, verás como los beneficios de diseñar interfaces cobran vida.
	 
	 </p>
  </body>
</html>

 