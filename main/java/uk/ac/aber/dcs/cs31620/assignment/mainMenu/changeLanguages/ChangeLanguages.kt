package uk.ac.aber.dcs.cs31620.assignment.mainMenu.changeLanguages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import uk.ac.aber.dcs.cs31620.assignment.R
import uk.ac.aber.dcs.cs31620.assignment.databinding.FragmentChangeLanguagesBinding
private const val FIRST = "FIRST LANGUAGE"
private const val SECOND = "SECOND LANGUAGE"
class ChangeLanguages : Fragment(), View.OnClickListener {

    private lateinit var changeLanguagesBinding: FragmentChangeLanguagesBinding
    private val changeLanguagesViewModel: changeLanguagesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeLanguagesBinding = FragmentChangeLanguagesBinding.inflate(inflater, container, false)
        changeLanguagesBinding.submitLanguagesButton2.setOnClickListener(this)

        return changeLanguagesBinding.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submitLanguagesButton2 -> {
                deleteAll()
            }
            else -> {
            }
        }
    }

    private fun deleteAll(){
        if(changeLanguagesBinding.firstLanguageEditText2.text.isNotEmpty() && changeLanguagesBinding.secondLanguageEditText2.text.isNotEmpty()) {
            changeLanguagesViewModel.deleteAll()
        }else{
            Toast.makeText(requireContext(), getString(R.string.missing_data), Toast.LENGTH_SHORT)
                .show()
        }


    }
    private fun restoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            val firstLanguage = savedInstanceState.getString(FIRST, "")
            if (firstLanguage.isNotEmpty()) changeLanguagesBinding.firstLanguageEditText2.setText(firstLanguage)
            val secondLanguage = savedInstanceState.getString(SECOND, "")
            if (secondLanguage.isNotEmpty()) changeLanguagesBinding.secondLanguageEditText2.setText(secondLanguage)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(FIRST, changeLanguagesBinding.firstLanguageEditText2.text.toString())
        outState.putString(SECOND, changeLanguagesBinding.secondLanguageEditText2.text.toString())

        super.onSaveInstanceState(outState)
    }

}