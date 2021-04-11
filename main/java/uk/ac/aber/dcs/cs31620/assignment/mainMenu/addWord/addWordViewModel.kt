package uk.ac.aber.dcs.cs31620.assignment.mainMenu.addWord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.assignment.word.Word
import uk.ac.aber.dcs.cs31620.assignment.dataSource.AssignmentRepository

class AddWordViewModel(application: Application) : AndroidViewModel(application)  {
    private val repository: AssignmentRepository = AssignmentRepository(application)

    fun insertWord(word: Word){
        repository.insert(word)
    }
}