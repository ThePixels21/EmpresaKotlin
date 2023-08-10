import model.*

fun main(args: Array<String>) {
    //Pruebas
    val empresa = Empresa("whatever", 24245, "Cali")
    println(empresa.buscarEmpleado(1010)?.getNombre())
    println(empresa.eliminarEmpleado(1010))
    empresa.registrarCliente(Cliente("Juan", 1334, "juan@gmail.com", "Armenia", "3536336"))
    println(empresa.buscarCliente(1334)?.getNombre())
    empresa.editarCliente(Cliente("Carlos", 1334, "carlos@gmail.com", "Medellín", "32429479"))
    println(empresa.buscarCliente(1334)?.getNombre())
    empresa.eliminarCliente(1334)
    println(empresa.buscarCliente(1334)?.getNombre())
    empresa.registrarEmpleado(Empleado("Mario", 2424, "mario@gmail.com",10.0, Dependencia("Whatever"), Cargo("Secretario", 8)))
    empresa.aniadirSubordinado(1010, 2424)
    println(empresa.buscarEmpleado(1010)?.buscarSubordinado(2424)?.getNombre())
    empresa.buscarEmpleado(1010)?.eliminarSubordinado(2424)
    println(empresa.buscarEmpleado(1010)?.buscarSubordinado(2424)?.getNombre())

    //Nominas
    println(empresa.obtenerNominaEmpresa())
    println(empresa.obtenerNominaDependencia(Dependencia("whatever")))
    println()

    //Función de dividir mediante restas
    val a = 12
    val b = 3
    val resultado = dividir(a, b)
    println("$a / $b = $resultado")
}
fun dividir(a: Int, b: Int): Int {
    if (a >= b) {
        val resta = a - b
        return dividir(resta, b) + 1
    } else {
        return 0
    }
}