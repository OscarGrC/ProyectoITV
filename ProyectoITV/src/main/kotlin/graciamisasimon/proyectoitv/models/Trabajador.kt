package graciamisasimon.proyectoitv.models

import graciamisasimon.proyectoitv.models.enums.TipoTrabajador
import java.time.LocalDate
import java.util.UUID

data class Trabajador (val estacionId:String, val nombre:String, val telefono:String, val correo:String,
           val usuario:String, val tipo: TipoTrabajador, val contraseña:String, val fechaContratacion:LocalDate,
           val plusGerencia:Boolean = false){
    val sueldo:Int
        get() = CalcularSueldo()
    private fun CalcularSueldo():Int{
        var total:Int = 0
        // añadimos su sueldo base por categoria
        when(tipo){
            TipoTrabajador.ADMINISTRACION -> total += 1650
            TipoTrabajador.INTERIOR -> total+=1750
            TipoTrabajador.MECANICO -> total+=1600
            TipoTrabajador.MOTOR -> total+=1700
            TipoTrabajador.ELECTRICISTA -> total+=1800
        }
      // añadimos plus gerencia si corresponde
      if(plusGerencia){ total+=1000}
      // añadimos antiguedad 100 x cada 3 años
       total+= CalcularPlusAntiguedad()
        return total
    }

   private fun CalcularPlusAntiguedad():Int{
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
           plus-=10
       }
       return  plus
   }
}