// Obtiene el id de los campos del formulario
const nombre = document.getElementById("nombre");
const apellido = document.getElementById("apellido");
const correo = document.getElementById("correo");
const telefono = document.getElementById("telefono");
const matricula = document.getElementById("matricula");
const tipo = document.getElementById("tipo");
const enviar = document.getElementById("enviar");

// Agregar un listener al campo1 y campo2 para controlar la visibilidad del campo3 y campo4 
nombre.addEventListener("input", function() {
  if (nombre.value !== "" && apellido.value !== "") {
    correo.style.display = "block";
    telefono.style.display = "block";
  } else {
    correo.style.display = "none";
    telefono.style.display = "none";
  }
});

apellido.addEventListener("input", function() {
    if (nombre.value !== "" && apellido.value !== "") {
        correo.style.display = "block";
        telefono.style.display = "block";
      } else {
        correo.style.display = "none";
        telefono.style.display = "none";
      }
})

correo.addEventListener("input", function() {
    if (correo.value !== "" && telefono.value !== "") {
        matricula.style.display = "block";
        tipo.style.display = "block";
    } else {
        matricula.style.display = "none";
        tipo.style.display = "none";
    }
});

telefono.addEventListener("input", function() {
    if (correo.value !== "" && telefono.value !== "") {
        matricula.style.display = "block";
        tipo.style.display = "block";
    } else {
        matricula.style.display = "none";
        tipo.style.display = "none";
    }
});

enviar.addEventListener("input", function() {
    if (matricula.value !== "" && tipo.value !== "") {
        enviar.display = "block";
    } else {
        enviar.display = "none";
    }
});

tipo.addEventListener("input", function() {
    if (matricula.value !== "" && tipo.value !== "") {
        enviar.style.display = "block";
    } else {
        enviar.style.display = "none";
    }
});