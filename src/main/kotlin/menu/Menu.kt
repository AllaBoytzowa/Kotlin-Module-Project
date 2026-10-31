package menu

import java.util.Scanner

abstract class Menu(val title: String) {
    abstract fun buildCommands(): List<MenuItem>

    private val scanner: Scanner = Scanner(System.`in`)
    val commands: List<MenuItem>
        get() {
            return buildCommands()
        }

    public fun printCommands() {
        println(title)
        for ((index, command) in commands.withIndex()) {
            command.print(index)
        }
    }

    public fun read() {
        while (true) {
            print("Введите команду: ")
            if (!scanner.hasNextInt()) {
                scanner.nextLine()
                println("Введённый символ не является числом")
                printCommands()
                continue
            }

            val commandIndex: Int = scanner.nextInt()
            if (commandIndex >= 0 && commandIndex < commands.size) {
                commands[commandIndex].execute()
                break
            } else {
                println("Данная команда не найдена")
            }
        }
    }

    public fun execute() {
        printCommands()
        read()
    }
}