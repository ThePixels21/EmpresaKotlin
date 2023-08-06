package model

open class Persona (
    private var nombre: String,
    private val documento: Long,
    private var correo: String) {

    fun getNombre () : String {
        return this.nombre
    }

    fun getDocumento () : Long {
        return this.documento
    }

    fun getCorreo () : String {
        return this.correo
    }

    fun setNombre (nombre : String) {
        this.nombre = nombre
    }

    fun setCorreo (correo : String) {
        this.correo = correo
    }

}