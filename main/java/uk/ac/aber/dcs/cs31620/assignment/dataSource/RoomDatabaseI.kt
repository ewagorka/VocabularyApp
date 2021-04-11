package uk.ac.aber.dcs.cs31620.assignment.dataSource

import uk.ac.aber.dcs.cs31620.assignment.word.WordDAO

interface RoomDatabaseI {
    fun wordDao(): WordDAO
    fun closeDb()
}