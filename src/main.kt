package search

fun main() {
    var inputNum: Int
    var employees = emptyArray<String>()
    do {
        inputNum = try {
            println("Enter number of employees to add:")
            readLine()!!.trim().toInt()
        } catch (e: NumberFormatException) {
            println("Not a valid input!")
            0
        }
    } while (inputNum  == 0)
    println("Enter all new employees data now:")
    for (i in 1..inputNum) {
        employees += readLine()!!
    }
    println()
    do {
        inputNum = try {
            println("Enter the number of search queries:")
            readLine()!!.trim().toInt()
        } catch (e: NumberFormatException) {
            println("Not a valid input!")
            0
        }
    } while (inputNum == 0)
    for (i in 1..inputNum) {
        println()
        println("Enter data to search employees:")
        val searchBy = readLine()!!.toLowerCase()
        var employeesFound = emptyArray<String>()
        for (j in employees.indices) {
            if (employees[j].toLowerCase().indexOf(searchBy) != -1) {
                employeesFound += employees[j]
            }
        }
        if (employeesFound.isNotEmpty()) {
            println()
            println("Found employees:")
            for (element in employeesFound) {
                println(element)
            }
        } else println("No matching employee found.")
    }
}