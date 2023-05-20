package graciamisasimon.proyectoitv.models

data class ValoresPruebas(var frenado:Double=0.0, var contaminacion:Double=0.0,
                          var interiores:Boolean = false, var luces:Boolean = false, var favorable:Boolean= false) {
}