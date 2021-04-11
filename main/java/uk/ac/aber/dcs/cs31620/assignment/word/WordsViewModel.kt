package uk.ac.aber.dcs.cs31620.assignment.word

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.assignment.R
import uk.ac.aber.dcs.cs31620.assignment.dataSource.AssignmentRepository

class WordsViewModel(application: Application):AndroidViewModel(application) {
    private val repository: AssignmentRepository =
        AssignmentRepository(
            application
        )
    var wordList: LiveData<List<Word>> = repository.getAllWords()
        private set

    private val anyType = application.resources.getStringArray(R.array.type_of_speech_array)[0]
    private var type = anyType

    fun getWords(type: String)
            : LiveData<List<Word>> {
        var changed = false

        if (this.type != type) {
            this.type = type
            changed = true
        }

        if (changed) {

            if (type != type) {
           //     wordList = repository.getWordsByType(type)
            }

        }
        return wordList
    }

    fun deleteAll(){
        var wordList: LiveData<List<Word>> = repository.getAllWords()
    }
}