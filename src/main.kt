package search
import java.io.File

class Search {
    companion object {
        /**
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
         */
        fun action(): Int {
            println()
            println("=== Menu ===\n1. Find a employee.\n2. List all employee data.\n0. Exit.")
            return  try {
                readLine()!!.trim().toInt()
            } catch (e: NumberFormatException) {
                4
            }
        }
        fun strat(): String {
            println()
            println("Select a matching strategy: ALL, ANY, NONE")
            return readLine()!!.toUpperCase()


        }
        fun fined(employees: Array<String>, strat: String) {
            println()
            println("Enter data to search employees:")
            val myMap = mutableMapOf<String, String>()
            for (i in employees.indices) {
                val word = employees[i].split(" ")
                for (e in word) {
                    if (!myMap.containsKey(e)) {
                        myMap[e] = "$i"
                    } else myMap[e] += " $i"
                }
            }
            var line = emptyArray<String>()
            when (strat) {
                "ANY" -> {
                    val searchBy = readLine()!!.toLowerCase().split(" ")
                    for (i in searchBy.indices) {
                        for ((key, value) in myMap) {
                            if (searchBy[i] == key.toLowerCase()) {
                                val list = value.split(" ").toTypedArray()
                                for (j in list) {
                                    if (!line.contains(j)) {
                                        line += j
                                    }
                                }
                            }
                        }
                    }
                }
                "ALL" -> {
                    val searchBy = readLine()!!.toLowerCase()
                    for (i in employees.indices) {
                        if (employees[i].toLowerCase().contains(searchBy)) {
                            line += "$i"
                        }
                    }
                }
                else -> {
                    var list = emptyArray<String>()
                    if (strat == "NONE") {
                        val searchBy = readLine()!!.toLowerCase().split(" ")
                        for ((key, value) in myMap) {
                            if (searchBy.contains(key.toLowerCase())) {
                                val newList = value.split(" ")
                                for(i in newList) {
                                    if (!list.contains(i)) {
                                        list += i
                                    }
                                }
                            }
                        }
                        for (i in employees.indices) {
                            if (!list.contains("$i") ) {
                                if (!line.contains("$i"))
                                    line += "$i"
                            }
                        }

                    }
                }
            }

            if (line.isNotEmpty()) {
                println("${line.size} employees found:")
                for (element in line) {
                    println(employees[element.toInt()])
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

fun main(args: Array<String>) {

    val file = "src/" + args[1]
    val employees = File(file).readLines().toTypedArray()

    //employees += Search.addEmployees()

    do {
        val action = Search.action()
        when (action) {
            1 -> Search.fined(employees, Search.strat())
            2 -> Search.printData(employees)
            0 -> println("\nBye!")
            else -> println("\nIncorrect option! Try again.")
        }

    } while (action != 0)
}