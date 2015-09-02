# programacionWeb-tp2

Requerimientos

- Jboss 9/ wildfly
- JDK 1.7 para arriba
- maven

Cada vez que cambian algo en el pom.xml, puede que no les deploye porque el IDE intenta cambiar la extension del archivo,
pero el IDE les avisa esto y les muestra un boton FIX, hacen cilck y en el path le agregar .war. OJO hacer esto solo
si hace falta. 

# Creación de Base de Datos

Requerimientos
- Postgres 9.3.X (o versiones posteriores) 
- pgAdmin3

Para la creación de base de datos instale postgreSQL, puede realizarlo a través de la consolda de comandos o bien utilizando la pgAdmin.

pgAdmin

Ingrese a la herramienta, en caso de no tener un server creado, le solicitará crearlo, configurelo para utilizarlo como localhost con los siguientes datos:
- name: {nombre_server}
- host: localhost
- port: 5432 (predefinido por postgresSQL
- username: postgres
- pass: postgres (o la contraseña que haya especificado para el usuario postgres)

Una vez creado, debe crear una nueva base de datos con el nombre "ventas" y cargar el archivo datos.sql del repositorio, esto lo puede realizar seleccionando la opción para insertar SQL de la barra de herramientas de pgAdmin,
cargue el archivo datos.sql y ejecutelo. Esto lo deberá crear la tabla ventas con 100 registro.

Consola
- Ingrese con el usuario postgres (usuario por defecto de postgres)
- Primero debemos crear la base de datos
  Ingrese: createdb {nombre_db} // en este caso createdb ventas
- Y luego ejecute el sgte comando:
  psql ventas <- /.../.../datos.sql
  Esto le creará la tabla y cargará los datos en la misma.
- Para verificarlo puede accedear a la base de datos y realizar un select sobre la misma:
  - $ psql ventas
  - $ select * from ventas;



Para agregar el DATASOURCE

- Levantar JBOSS9 e ir a localhost:8080
- Click en Administration Console
- Click en datasource
- Click en subsystems
- Click en datasource, click en view
- Click en add, seleccionar PostgresSQL Datasource
- Escribir el nombre del datasource y su JDNI (por defecto usamos PostgresDS y java:/PostgresDS
- Click en detected driver, seleccionar restService.war_org.postrgressql.Driver_9_3 o cualquier otro menos h2
- Cambiar la ultima parte de la url a /ventas (por defecto esta con el nombre del datasource en nuestro caso PostgresDS)
- Introducir usuario y contrasenha postgres postgres y darle test Connection. Si todo sale bien click en Done

