----------Creación del repositorio para la entrega final----------
Creadas las carpetas BACKEND y FRONTEND.

################################################################################
									
1. Documentación para la instalación y configuración Docker

https://docs.docker.com/engine/install/ubuntu/

Se recomienda instalar usando el apt repository, en esta misma 
página buscar el párrafo: "Install using the apt repository".

################################################################################

REPARTO DE TAREAS

BDAdaptador: Angel García y Juanje
Paciente: Manu
Tratamiento: Felipe
Pacientes: Angel 
Server,MYSQL: Noelia


################################################################################

REUNIONES SCRUM

14/05/2023

Noelia: Desplegado el contenedor en Docker, mueve .war a webwapps y soluciona 
problema 404. Editar archivo content.xml para acceder al administrados
desde cualquier máquina.

Juanje: Prepara el script de MYSQL con las tablas necesarias, 
generando insertos para sus posteriores pruebas, ayuda a Noelia 
con Tomcat.

Se ha realizado el reparto de tareas.
Comentamos dudas acerca del proyecto en general.

17/05/23

Servidor desplegado y clases creadas, deberían funcionar.

################################################################################

PROBLEMAS ENCONTRADOS 

- Error 404 (solucionado): Dentro de webapp debería estar la aplicación manager, 
ya que tenemos un problema al acceder por el puerto 8080. 
Al acceder por éste, tendría que aparecer el panel de administración 
de Tomcat, por lo que nos mostraba error 404.

- Error 403 (solucionado): Falta la linea Valve en el archivo content.xml
Además, hay que añadir roles y usuarios al fichero tomcat-users.xml.
Se agrega el archivo manager.xml a la ruta "conf/Catalina/localhost",
dentro de éste, se añaden las siguientes líneas: 

- Falta el atributo sDniPaciente en Tratamiento.

- No funciona la petición o se está realizando mal desde el navegador.

<Context privileged="true" antiResourceLocking="false" docBase="${catalina.home}/webapps/manager">
    <Valve className="org.apache.catalina.valves.RemoteAddrValve" allow="^.*$" />
</Context>











