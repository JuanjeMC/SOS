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

