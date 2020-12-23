package search

class Search {
    companion object {
        fun addEmployees(): Array<String> {
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
            return employees
        }

        fun action(): Int {
            println()
            println("=== Menu ===\n1. Find a employee.\n2. List all employee data.\n0. Exit.")
            return  readLine()!!.trim().toInt()
        }

        fun fined(employees: Array<String>) {
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
                //println()
                //println("Found employees:")
                for (element in employeesFound) {
                    println(element)
                }
            } else println("No matching employee found.")
        }

        fun printData(employees: Array<String>) {
            println()
            println("=== List of Employees ===")
            for (element in employees) {
                println(element)
            }

        }

    }
}

fun main() {
    var employees = emptyArray<String>()
    employees += Search.addEmployees()

    do {
        val action = Search.action()
        when (action) {
            1 -> Search.fined(employees)
            2 -> Search.printData(employees)
            0 -> println("\nBye!")
            else -> println("\nIncorrect option! Try again.")
        }

    } while (action != 0)
}