package model

open class Persona (
    protected var nombre: String,
    protected val documento: Long,
    protected var correo: String) {

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