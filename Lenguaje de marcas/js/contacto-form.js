
// Obtener referencia al botón de enviar
const botonEnviar = document.getElementById("enviar");

// Agregar evento click al botón
botonEnviar.addEventListener("click", function (event) {
    // Obtener referencias a los campos del formulario
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const dni = document.getElementById("dni").value;
    const correo = document.getElementById("correo").value;

    // Verificar si todos los campos están completos
    if (nombre != "" && apellido != "" && dni != "" && correo != "") {
        // Cambiar el color del botón a azul
        botonEnviar.style.backgroundColor = "blue";

        // Enviar el formulario por correo (código de envío de correo aquí)
        // ...
    } else {
        // Mostrar mensaje de error si faltan campos
        alert("Por favor, completa todos los campos del formulario.");
    }

    // Evitar que el formulario se envíe automáticamente
    event.preventDefault();
});
