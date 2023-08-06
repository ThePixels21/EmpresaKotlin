package model

class Cargo (
    val nombre: String,
    var nivel: Int) {

    fun getNombre () : String {
        return this.nombre
    }

    fun getNivel () : Int {
        return this.nivel
    }

    fun setNivel (nivel: Int) {
        this.nivel = nivel
    }
}