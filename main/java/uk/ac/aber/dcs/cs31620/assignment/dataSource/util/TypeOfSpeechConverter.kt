package uk.ac.aber.dcs.cs31620.assignment.dataSource.util


import androidx.room.TypeConverter
import uk.ac.aber.dcs.cs31620.assignment.TypeOfSpeech

object TypeOfSpeechConverter {

    @TypeConverter
    @JvmStatic
    fun toString(typeOfSpeech: TypeOfSpeech) = typeOfSpeech.toString()

    @TypeConverter
    @JvmStatic
    fun toTypeOfSpeech(typeOfSpeech: String) = TypeOfSpeech.valueOf(typeOfSpeech)
}