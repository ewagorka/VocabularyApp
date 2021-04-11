package uk.ac.aber.dcs.cs31620.assignment.dataSource

import android.app.Application
import datasource.Injection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.assignment.word.Word

class AssignmentRepository(application: Application) {
    private val wordDao = Injection.getDatabase(application).wordDao()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insert(word: Word){
        coroutineScope.launch(Dispatchers.IO) {
            wordDao.insertWord(word)
        }
    }


    fun getAllWords() = wordDao.getAllWords()

    fun deleteAll()= wordDao.deleteAll()


   // fun getWordsByType(typeOfSpeech: String)= wordDao.getWordsByType(typeOfSpeech)


}