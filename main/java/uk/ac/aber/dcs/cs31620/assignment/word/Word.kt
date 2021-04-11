package uk.ac.aber.dcs.cs31620.assignment.word

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int =0,
    val word:String ="",
    val translation: String = ""
    //val typeOfSpeech: TypeOfSpeech = TypeOfSpeech.DIFFERENT)
)