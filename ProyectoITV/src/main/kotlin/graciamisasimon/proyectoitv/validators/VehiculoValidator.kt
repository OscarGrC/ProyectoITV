package graciamisasimon.proyectoitv.validators

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import graciamisasimon.proyectoitv.errors.VehiculosError
import graciamisasimon.proyectoitv.models.Vehiculo
import java.time.LocalDate

fun Vehiculo.validate(): Result<Vehiculo, VehiculosError> {
    if (this.matricula.isEmpty()) {
        return Err(VehiculosError.ValidationProblem("La matricula no puede estar vacía"))
    }
    if (this.marca.isEmpty()) {
        return Err(VehiculosError.ValidationProblem("La marca no pueden estar vacía"))
    }
    if (this.modelo.isEmpty()) {
        return Err(VehiculosError.ValidationProblem("El modelo no pueden estar vacío"))
    }
    if (this.fechaMatriculacion >LocalDate.now()) {
        return Err(VehiculosError.ValidationProblem("La fecha de matriculación no puede ser el futuro"))
    }
    if ((this.fechaUlimaRevision != null) && (this.fechaUlimaRevision < fechaMatriculacion)) {
        return Err(VehiculosError.ValidationProblem("La revision no puede ser anterior a la matriculacion"))
    }
    propietario.validate()

    return Ok(this)
}