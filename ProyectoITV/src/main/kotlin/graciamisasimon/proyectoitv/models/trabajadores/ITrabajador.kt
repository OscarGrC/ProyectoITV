package graciamisasimon.proyectoitv.models.trabajadores

import graciamisasimon.proyectoitv.models.enums.TipoTrabajador
import java.time.LocalDate

interface ITrabajador {
    val estacionId:String
    val nombre:String
    val telefono:String
    val correo:String
    val usuario:String
    val tipo: TipoTrabajador
    val password:String
    val fechaContratacion: LocalDate
    val plusGerencia:Boolean
    val sueldo:Int
        get()= calcularSueldo()
    fun salarioBase():Int
    private fun calcularSueldo():Int{

        // añadimos su sueldo base por categoria
        var total:Int = salarioBase()
        // añadimos plus gerencia si corresponde
        if(plusGerencia){ total+=1000}
        // añadimos antiguedad 100 x cada 3 años
        total+= calcularPlusAntiguedad()
        return total
    }

    private fun calcularPlusAntiguedad():Int{
        var fechaContratacionLocal = fechaContratacion.toString()
        var anyoContratacion = fechaContratacionLocal.split("-")[0].toInt()
        var mesContratacion = fechaContratacionLocal.split("-")[1].toInt()
        var plus:Int = 0
        while(anyoContratacion<LocalDate.now().year){
            if((anyoContratacion+3)<=LocalDate.now().year){
                plus+=100
            }
            anyoContratacion+=3
        }
        if(mesContratacion<LocalDate.now().month.value && anyoContratacion==LocalDate.now().year){
            plus-=100
        }
        return  plus
    }
}