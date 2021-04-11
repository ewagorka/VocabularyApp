package uk.ac.aber.dcs.cs31620.assignment.word

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insertWord(word: Word)

    @Insert
    fun insertMultipleWords(wordsList: List<Word>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateWord(word: Word)

    @Delete
    fun deleteWord(word: Word)

    @Query("DELETE FROM words")
    fun deleteAll()

    @Query("SELECT * FROM words")
    fun getAllWords(): LiveData<List<Word>>
   /*@Query("SELECT * FROM words WHERE typeOfSpeech = :typeOfSpeech")
    fun getWordsByType(typeOfSpeech: String):LiveData<List<Word>>*/


}