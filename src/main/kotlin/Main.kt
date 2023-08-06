import model.Cliente

fun main(args: Array<String>) {
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