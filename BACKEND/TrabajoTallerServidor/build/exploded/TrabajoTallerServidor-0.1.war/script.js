function opcion(id){ 
    if( id == "1"){
        document.getElementById("insertP").style.display = "contents";
        document.getElementById("insertT").style.display = "none";
        document.getElementById("listP").style.display = "none";
        document.getElementById("listT").style.display = "none";
    }
    if( id == "2"){
        document.getElementById("insertP").style.display = "none";
        document.getElementById("insertT").style.display = "contents";
        document.getElementById("listP").style.display = "none";
        document.getElementById("listT").style.display = "none";
    }
    if( id == "3"){
        document.getElementById("insertP").style.display = "none";
        document.getElementById("insertT").style.display = "none";
        document.getElementById("listP").style.display = "contents";
        document.getElementById("listT").style.display = "none";
    }
    if( id == "4"){
        document.getElementById("insertP").style.display = "none";
        document.getElementById("insertT").style.display = "none";
        document.getElementById("listP").style.display = "none";
        document.getElementById("listT").style.display = "contents";
    }

}

function peticion(id){
    
    if (id=="ip"){

        var dni = document.getElementById("dniP").value;
        var nombre = document.getElementById("nombreP").value;
        var apellidos = document.getElementById("apellidosP").value;
        var fecha = document.getElementById("fNac").value;
        var telefono = document.getElementById("telefonoP").value;
        var email = document.getElementById("emailP").value;
    
        var sCSV = dni + ";" + nombre + ";" + apellidos + ";" + fecha + ";" + telefono + ";" + email;

        window.location.href = "http://141.144.229.103:8080/TrabajoTallerServidor-0.1/Pacientes?peticion=insertPaciente&sCSVPaciente=" + sCSV;
        
    }

    if (id=="it"){

        var codT = document.getElementById("codT").value;
        var descripcionT = document.getElementById("descripcionT").value;
        var fechaT = document.getElementById("fechaT").value;
        var precioT = document.getElementById("precioT").value;
        var dniP = document.getElementById("dniT").value;
        var cobrado = document.getElementById("cobrado").value;

        var sCSV = codT + ";" + descripcionT + ";" + fechaT + ";" + precioT + ";" + cobrado + ";" + dniP;

        window.location.href = "http://141.144.229.103:8080/TrabajoTallerServidor-0.1/Pacientes?peticion=insertTratamiento&sCSVTratamiento=" + sCSV;


    }

    if (id=="lp"){

        var apellidos = document.getElementById("apellP").value;

        window.location.href = "http://141.144.229.103:8080/TrabajoTallerServidor-0.1/Pacientes?peticion=listaPacientes&sapellidos=" + apellidos;




    }

    if (id=="lt"){

        var dni = document.getElementById("dniPT").value;

        window.location.href = "http://141.144.229.103:8080/TrabajoTallerServidor-0.1/Pacientes?peticion=listaTratamientos&dniPaciente=" + dni;
        

    }

    if (id=="contenedor-imagen"){
        window.location.href = "http://141.144.229.103:8080/TrabajoTallerServidor-0.1/";
    }
}

