package model

class Empleado (
    nombre: String,
    documento: Long,
    correo: String,
    private var salarioUnico: Double,
    private var dependencia: Dependencia,
    private val subordinados: List<Empleado> = mutableListOf(),
    private var cargo: Cargo) : Persona(nombre, documento, correo) {

        fun getSalarioUnico () : Double {
            return this.salarioUnico
        }

        fun getDependencia () : Dependencia {
            return this.dependencia
        }

        fun getSubordinados () : List<Empleado> {
            return this.subordinados
        }

        fun getCargo () : Cargo {
            return this.cargo
        }

        fun setSalarioUnico (salarioUnico : Double) {
            this.salarioUnico = salarioUnico
        }

        fun setDependencia (dependencia: Dependencia) {
            this.dependencia = dependencia
        }

        fun setCargo (cargo: Cargo) {
            this.cargo = cargo
        }
}