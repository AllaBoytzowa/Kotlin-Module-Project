import menu.Menu
import menu.MenuItem
import models.NoteModel

class NoteMenu(
  val note: NoteModel
) : Menu("Выбрана заметка: \"${note.title}\""){

    override fun buildCommands(): List<MenuItem> {
        return listOf(
            MenuItem("Посмотреть заметку") {
                println("Заметка: ${note.title}")
                println(note.content)

                execute()
            },
            MenuItem("Назад") {
                println("Возвращаемся к списку заметок")
            }
        )
    }

}