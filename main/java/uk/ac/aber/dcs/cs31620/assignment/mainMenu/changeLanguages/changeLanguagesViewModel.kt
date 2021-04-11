package uk.ac.aber.dcs.cs31620.assignment.mainMenu.changeLanguages

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import uk.ac.aber.dcs.cs31620.assignment.dataSource.AssignmentRepository

class changeLanguagesViewModel(application: Application) : AndroidViewModel(application)  {
    private val repository: AssignmentRepository = AssignmentRepository(application)

    fun deleteAll(){
        repository.deleteAll()
    }
}