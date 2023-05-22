package graciamisasimon.proyectoitv.models

import graciamisasimon.proyectoitv.models.enums.TipoTrabajador
import java.time.LocalDate

class Trabajador(
        val estacionId:String,
        val nombre:String,
        val telefono:String,
        val correo:String,
        val usuario:String,
        val tipo: TipoTrabajador,
        val password:String,
        val fechaContratacion: LocalDate,
        val plusGerencia:Boolean){
        val sueldo:Int
        get()= calcularSueldo()

        private fun calcularSueldo():Int{

            // añadimos su sueldo base por categoria
            var total:Int = 0
            when(tipo) {
                TipoTrabajador.ADMINISTRACION -> total += 1650
                TipoTrabajador.MOTOR-> total += 1700
                TipoTrabajador.ELECTRICISTA -> total += 1800
                TipoTrabajador.MECANICO -> total += 1600
                TipoTrabajador.INTERIOR -> total += 1750
            }
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
            while(anyoContratacion< LocalDate.now().year){
                if((anyoContratacion+3)<= LocalDate.now().year){
                    plus+=100
                }
                anyoContratacion+=3
            }
            if(mesContratacion< LocalDate.now().month.value && anyoContratacion== LocalDate.now().year){
                plus-=100
            }
            return  plus
        }
    }
