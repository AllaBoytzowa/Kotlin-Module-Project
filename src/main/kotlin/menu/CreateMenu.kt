package menu

import java.util.Scanner

class CreateMenu(
    val title: String
) {
    private val scanner: Scanner = Scanner(System.`in`)

    fun read(): String {
        while (true) {
            print(title)
            if (!scanner.hasNextLine()) {
                scanner.nextLine()
                println("Введено некорректное значение")
                continue
            }
            val value: String = scanner.nextLine()

            if (value.trim().isEmpty()) {
                println("Введено пустое значение")
                continue
            }

            return value
        }
    }
}