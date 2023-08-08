package model

import java.util.Optional

class Empresa (
    private var razonSocial: String,
    private val nit: Long,
    private var direccion: String,
    private val personas: MutableList<Persona> = mutableListOf()) {

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
            if (empleado.getDependencia().getNombre() == dependencia.getNombre()) {
                nomina += empleado.getSalarioUnico()
            }
        }
        return nomina
    }

    fun buscarEmpleado (documento : Long) : Empleado? {
        for (empleado in personas.filterIsInstance<Empleado>()) {
            if(empleado.getDocumento() == documento) {
                return empleado
            }
        }
        return null
    }

    fun registrarEmpleado (empleado : Empleado?) : Boolean{
        if(empleado != null && this.buscarEmpleado(empleado.getDocumento()) == null) {
            this.personas.add(empleado)
            return true
        } else {
            return false
        }
    }

    fun eliminarEmpleado(documento : Long) : Boolean {
        var empleado : Empleado? = this.buscarEmpleado(documento)
        if(empleado != null) {
            if(personas.size>1) {
                return personas.remove(empleado)
            } else {
                println("La empresa debe tener al menos un empleado")
            }
        } else {
            println("No se encontró")
        }
        return false
    }

    fun editarEmpleado (empleado : Empleado?) : Boolean {
        if(empleado != null) {
            var empleadoExistente : Empleado? = this.buscarEmpleado(empleado.getDocumento())
            if(empleadoExistente != null) {
                empleadoExistente.setNombre(empleado.getNombre())
                empleadoExistente.setCorreo(empleado.getCorreo())
                empleadoExistente.setCargo(empleado.getCargo())
                empleadoExistente.setDependencia(empleado.getDependencia())
                empleadoExistente.setSalarioUnico(empleado.getSalarioUnico())
                return true
            }
        }
        return false
    }

    fun buscarCliente (documento : Long) : Cliente? {
        for (cliente in personas.filterIsInstance<Cliente>()) {
            if(cliente.getDocumento() == documento) {
                return cliente
            }
        }
        return null
    }

    fun registrarCliente (cliente : Cliente?) : Boolean {
        if(cliente != null && this.buscarCliente(cliente.getDocumento()) == null) {
            this.personas.add(cliente)
            return true
        } else {
            return false
        }
    }

    fun eliminarCliente (documento : Long) : Boolean {
        var cliente : Cliente? = this.buscarCliente(documento)
        if(cliente != null) {
            return personas.remove(cliente)
        } else {
            return false
        }
    }

    fun editarCliente (cliente : Cliente?) : Boolean {
        if(cliente != null) {
            var clienteExistente : Cliente? = this.buscarCliente(cliente.getDocumento())
            if(clienteExistente != null) {
                clienteExistente.setNombre(cliente.getNombre())
                clienteExistente.setCorreo(cliente.getCorreo())
                clienteExistente.setDireccion(cliente.getDireccion())
                clienteExistente.setTelefono(cliente.getTelefono())
                return true
            }
        }
        return false
    }

    fun aniadirSubordinado (documentoEmpleado: Long, documentoSubordinado : Long) : Boolean {
        if(documentoEmpleado != documentoSubordinado) {
            var empleadoRegistrado = this.buscarEmpleado(documentoEmpleado)
            var subordinadoRegistrado = this.buscarEmpleado(documentoSubordinado)
            if(empleadoRegistrado != null && subordinadoRegistrado != null) {
                return empleadoRegistrado.aniadirSubordinado(subordinadoRegistrado)
            }
        }
        return false
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
}