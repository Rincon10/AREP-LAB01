# **API Calc-App 📲**

API que permite calcular valores de temperatura equivalentes a través de varias escalas de temperatura comúnmente utilizadas.

## **Prerrequisitos**

-   [Git](https://git-scm.com/downloads) - Sistema de control de versiones
-   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias
-   [Java 8](https://www.java.com/download/ie_manual.jsp) - Entorno de desarrollo
-   [Intellij Idea](https://www.jetbrains.com/es-es/idea/download/) (Opcional)


## **Instrucciones de ejecución local**

0. Desde cmd clonar el repositorio

```git
git clone https://github.com/Rincon10/AREP-LAB01
```


1. Ubicarse en la carpeta App y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean
```

2. Realizamos la compilación del proyecto
```maven
mvn package
```

3. Ejecutamos el proyecto
```maven
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.App"
```

4. Generando la documentación del proyecto
```mvn
mvn javadoc:javadoc
```
La documentación se generara en la ruta
```
target/site/apidocs/index.html
```

### **Más información**
para más información del API, revisar la [documentación](https://calcapp-frontend.herokuapp.com/public/documentation.html).


## **Ejecutando pruebas**
Para la ejecución de pruebas

```mvn
mvn test
```

 En este taller tenemos dos casos de pruebamostrando la respectiva conversión  Celsius-Fahrenheit y viceversa.

## **Construido con**
 -   [Spark](https://sparkjava.com/documentation#getting-started) - Framework Web
  -   [Maven](https://maven.apache.org/download.cgi) - Gestor de dependencias

## **Despliegue en Heroku**

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://calcapp-backend.herokuapp.com/api/v1/celsius/1)

## **Autor**

-   [Iván Camilo](https://github.com/Rincon10).