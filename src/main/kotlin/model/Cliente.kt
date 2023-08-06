package model

class Cliente (
    nombre: String,
    documento: Long,
    correo: String,
    private var direccion: String,
    private var telefono: String)
    : Persona(nombre, documento, correo) {

        fun getDireccion () : String {
            return this.direccion
        }

        fun getTelefono () : String {
            return this.telefono
        }

        fun setDireccion (direccion: String) {
            this.direccion = direccion
        }

        fun setTelefono (telefono: String) {
            this.telefono = telefono
        }
}