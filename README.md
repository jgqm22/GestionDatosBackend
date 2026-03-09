# GestionDatosBackend

Sistema Backend para la Gestión de Información relacionada a Pedidos desde diferentes Canales (Evaluación Gilberto Quintana

---

## Datos Generales
* Este proyecto fue desarrollado deliberadamente en español, buscando estar acorde al contenido del examen.
* Usa la estructura básica de arquitectura hexagonal para separar los dominios del proyecto, así como también las diferentes capass por su correrspondiente dominio.
* Por agilidad y simplificación, se usó un mismo proyecto para albergar los tres Servicios REST, sin embargo, cada uno esta delimitado.
* MongoDB se configuró para usarse en modo embebido tanto para pruebas unitarias como para su ejecución.

### URL de Proyecto en GitHub:
https://github.com/jgqm22/GestionDatosBackend

## 1. Requerimientos Minimos para su compilación y Ejecución

Considerar las siguientes dependencias para el correcto funcionamiento de este proyecto:

* Java 21 (Se recomienda Temurin o Correto)
* Maven 3.9.X
* Mongo 6.0.5

## 2. Compilación del Proyecto

Se consideran los siguientes puntos durante la compilación:
* Ejecución de Unit Test
* Validacion de Calidad de Código
* Validación de Cobertura de Código
* Generación de JAR

### En Windows:
```
build.cmd
```

### En Linux:
```
./build.sh
```

## 3. Ejecución del Proyecto:

### En Windows:
```
run.cmd
```

### En Linux:
```
./run.sh
```

## 4. Ligas de acceso

Una vez iniciada la aplicación, se pueden consultar las siguientes ligas:

### Liga para consulta de Swagger de los Servicios REST
http://localhost:8080/api/gestion-pedidos/swagger-ui/index.html

### Liga para API Rest de Clientes
http://localhost:8080/api/gestion-pedidos/v1/clientes

### Liga para API REST de pedidos
http://localhost:8080/api/gestion-pedidos/v1/pedidos

### Liga para API REST de Entregas
http://localhost:8080/api/gestion-pedidos/v1/entregas

## 5. Acerca de
Proyecto Demo creado para la evaluación de Gilberto Quintana