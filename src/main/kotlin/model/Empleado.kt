package model

class Empleado (
    nombre: String,
    documento: Long,
    correo: String,
    private var salarioUnico: Double,
    private var dependencia: Dependencia,
    private val subordinados: MutableList<Empleado> = mutableListOf(),
    private var cargo: Cargo) : Persona(nombre, documento, correo) {

        fun buscarSubordinado(documento : Long) : Empleado? {
            for (subordinado in subordinados) {
                if (subordinado.getDocumento() == documento) {
                    return subordinado
                }
            }
            return null
        }

        fun aniadirSubordinado(empleado: Empleado) : Boolean {
            val subordinado = buscarSubordinado(empleado.getDocumento())
            if(subordinado == null) {
                return subordinados.add(empleado)
            } else {
                return false
            }
        }

        fun eliminarSubordinado(documento : Long) : Boolean {
            val subordinado = buscarSubordinado(documento)
            if(subordinado != null) {
                return subordinados.remove(subordinado)
            } else {
                return false
            }
        }

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