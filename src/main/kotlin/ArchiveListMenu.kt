import menu.CreateMenu
import menu.Menu
import menu.MenuItem
import models.ArchiveModel

class ArchiveListMenu() : Menu("Список архивов:") {

    val archiveList: MutableList<ArchiveModel> = mutableListOf()

    override fun buildCommands(): List<MenuItem> {
        val menuList: MutableList<MenuItem> = mutableListOf()

        menuList.add(MenuItem("Создать архив") {
            val name: String = CreateMenu("Введите название архива: ").read()

            archiveList.add(ArchiveModel(name, mutableListOf()))
            println("Архив \"$name\" успешно создан")

            // Снова показываем меню и выбор
            execute()
        })

        for (archiveItem in archiveList) {
            menuList.add(MenuItem(archiveItem.name) {
                ArchiveMenu(archiveItem).execute()

                execute()
            })
        }

        menuList.add(MenuItem("Выход") {
            // Без вызова execute мы выходим из выполнения кода данного класса,
            // тем самым реализуется возвращение назад
            println("Программа завершена")
        })

        return menuList
    }
}
