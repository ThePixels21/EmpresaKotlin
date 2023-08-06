package model

class Empresa (
    private var razonSocial: String,
    private val nit: Long,
    private var direccion: String,
    private val personas: List<Persona> = mutableListOf()) {

    fun obtenerNominaEmpresa(): Double {
        var nomina: Double = 0.0
        for (empleado in personas.filterIsInstance<Empleado>()) {
            nomina += empleado.getSalarioUnico()
        }
        return nomina
    }

    fun obtenerNominaDependencia(dependencia: Dependencia): Double {
        var nomina: Double = 0.0
        for (empleado in personas.filterIsInstance<Empleado>()) {
            if (empleado.getDependencia() == dependencia) {
                nomina += empleado.getSalarioUnico()
            }
        }
        return nomina
    }

    fun getRazonSocial () : String {
        return this.razonSocial
    }

    fun getNit () : Long {
        return this.nit
    }

    fun getDireccion () : String {
        return this.direccion
    }

    fun getPersonas () : List<Persona> {
        return this.personas
    }

    fun getEmpleados () : List<Empleado> {
        return this.personas.filterIsInstance<Empleado>()
    }

    fun getClientes () : List<Cliente> {
        return this.personas.filterIsInstance<Cliente>()
    }

    fun setRazonSocial (razonSocial : String) {
        this.razonSocial = razonSocial
    }

    fun setDireccion (direccion : String) {
        this.direccion = direccion
    }

    fun buscarEmpleado (id : Long) : Empleado {
        return null!!
    }

    fun registrarEmpleado (empleado : Empleado) : Boolean{
        return true
    }

    fun eliminarEmpleado(id : Long) : Boolean {
        return true
    }

    fun editarEmpleado (empleado : Empleado) : Boolean {
        return true
    }

    fun buscarCliente (id : Long) : Cliente {
        return null!!
    }

    fun registrarCliente (cliente : Cliente) : Boolean {
        return true
    }

    fun eliminarCliente (id : Long) : Boolean {
        return true
    }

    fun editarCliente (cliente : Cliente) : Boolean {
        return true
    }
}