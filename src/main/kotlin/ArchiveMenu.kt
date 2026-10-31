import menu.CreateMenu
import menu.Menu
import menu.MenuItem
import models.ArchiveModel
import models.NoteModel

class ArchiveMenu(
    val archive: ArchiveModel
) : Menu("Список заметок из архива \"${archive.name}\":")  {

    override fun buildCommands(): List<MenuItem> {
        val menuList: MutableList<MenuItem> = mutableListOf()

        menuList.add(MenuItem("Создать заметку") {
            val name: String = CreateMenu("Введите название заметки: ").read()
            val text: String = CreateMenu("Введите текст заметки: ").read()

            archive.notes.add(NoteModel(name, text))
            println("Заметка \"$name\" успешно создана")

            // Снова показываем меню и выбор
            execute()
        })

        for (note in archive.notes) {
            menuList.add(MenuItem(note.title) {
                NoteMenu(note).execute()

                execute()
            })
        }

        menuList.add(MenuItem("Назад") {
            println("Возвращаемся к списку архивов")
        })

        return menuList
    }
}