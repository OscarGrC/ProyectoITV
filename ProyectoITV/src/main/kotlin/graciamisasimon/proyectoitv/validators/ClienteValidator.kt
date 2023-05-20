package graciamisasimon.proyectoitv.validators

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.errors.VehiculosError
import graciamisasimon.proyectoitv.models.Cliente

fun Cliente.validate():Result<Cliente, VehiculosError> {
        if (this.nombre.isEmpty()) {
            return Err(VehiculosError.ValidationProblem("La nombre no puede estar vacía"))
        }
        if (this.apellidos.isEmpty()) {
            return Err(VehiculosError.ValidationProblem("Los apellidos no pueden estar vacios"))
        }
        if (this.dni.isEmpty()) {
            return Err(VehiculosError.ValidationProblem("El dni no pueden estar vacío"))
        }
        if (!Regex("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$").matches(this.dni)){
            return Err(VehiculosError.ValidationProblem("Fallo con el dni"))
        }
        // Expresion regular de email
        if (this.correo.isEmpty() || !Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
                .matches(this.correo)) {
            return Err(VehiculosError.ValidationProblem("Fallo con el Email"))
        }
        return Ok(this)

}