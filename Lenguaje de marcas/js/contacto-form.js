
// Obtener referencia al botón de enviar
const botonEnviar = document.getElementById("enviar");

// Agregar evento click al botón
botonEnviar.addEventListener("click", function (event) {
    // Obtener referencias a los campos del formulario
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    
    const dni = document.getElementById("dni").value;
    const correo = document.getElementById("correo").value;
    const telefono = document.getElementById("telefono").value;
    const matricula = document.getElementById("matricula").value;
    const modelo = document.getElementById("modelo").value;
    const tipoCoche = document.getElementById("tipoCoche").value;
    // const fechaMatri = document.getElementById("").value;
    const marca = document.getElementById("marca").value;
    const tipoMotor = document.getElementById("tipoMotor").value;
    // const fechaCita = document.getElementById("fechaCita").value;
    const lugar = document.getElementById("lugar").value;

    var regexDNI = /^[0-9]{8}[A-Za-z]$/;
    var regexEmail = /^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\.[a-zA-Z]{2,}$/;
    var regexMatricula = /^[A-Z0-9]{1,7}$/;
    var regexTelefono = /^[0-9]{9}$/;
   

    // Verificar si todos los campos están completos
    if (nombre != "" && apellido != "" && regexDNI.test(dni) && regexEmail.test(correo) && regexTelefono.test(telefono) && regexMatricula.test(matricula) && modelo != "" && tipoCoche != "" && marca != "" && tipoMotor != "" && lugar != "") {
        // Cambiar el color del botón a azul
        botonEnviar.style.backgroundColor = "#1e88e5";

        // Enviar el formulario por correo 
        
        // Obtener la informacion del formulario 
        const form1 = document.getElementById("miFormulario1").value;
        const form2 = document.getElementById("miFormulario2").value;
        const form3 = document.getElementById("miFormulario3").value;
        
    } else {
        // Mostrar mensaje de error si faltan campos
        alert("Por favor, completa todos los campos del formulario.");
    }

    // Evitar que el formulario se envíe automáticamente
    event.preventDefault();
});