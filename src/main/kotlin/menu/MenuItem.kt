package menu

data class MenuItem(
    val name: String,
    val callback: () -> Unit
) {
    fun print(index: Int) {
        println("$index. $name")
    }

    fun execute() {
        callback()
    }
}