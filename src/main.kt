package search

fun main() {
    val input = readLine()!!.toLowerCase().split(" ")
    val searchBy = readLine()!!.toLowerCase()
    var inInput = false
    for (i in input.indices) {
        if (input[i] == searchBy) {
            println(i + 1)
            inInput = true
        }
    }
    if (!inInput) {
        println("Not found")
    }
}