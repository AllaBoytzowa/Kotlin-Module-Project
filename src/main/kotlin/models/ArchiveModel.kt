package models

data class ArchiveModel(
    val name: String,
    val notes: MutableList<NoteModel>
)
