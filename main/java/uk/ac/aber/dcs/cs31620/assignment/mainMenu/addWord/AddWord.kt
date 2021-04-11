package uk.ac.aber.dcs.cs31620.assignment.mainMenu.addWord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uk.ac.aber.dcs.cs31620.assignment.R
import uk.ac.aber.dcs.cs31620.assignment.word.Word
import uk.ac.aber.dcs.cs31620.assignment.databinding.FragmentAddWordBinding

private const val WORD = "WORD"
private const val MEANING = "MEANING"
class AddWord : Fragment(), View.OnClickListener {

    private var selectedType: String = ""
    private lateinit var addWordBinding: FragmentAddWordBinding
    private val addWordViewModel: AddWordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        addWordBinding = FragmentAddWordBinding.inflate(inflater, container, false)

        var values = resources.getStringArray(R.array.type_of_speech_array)
        val typeValues = values.copyOfRange(1, values.size)

        addWordBinding.submitButton.setOnClickListener(this)

        restoreInstanceState(savedInstanceState)

        //Spinner
        setupSpinner(addWordBinding.typeOfSpeechSpinner,typeValues)

        return addWordBinding.root
    }

    private fun setupSpinner(spinner: Spinner, values: Array<String>) {
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent === addWordBinding.typeOfSpeechSpinner) {
                    selectedType = values[position]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // We won't need this
            }
        }

        val adapter =
            ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_item
            )
        adapter.addAll(values.toList())

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
    }

    private fun restoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            val word = savedInstanceState.getString(WORD, "")
            if (word.isNotEmpty()) addWordBinding.word1.setText(word)
            val meaning = savedInstanceState.getString(MEANING, "")
            if (meaning.isNotEmpty()) addWordBinding.word1.setText(word)

        }
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submitButton -> {
                insertWord()
            }
            else -> {
            }
        }
    }

    private fun insertWord() {

        if (selectedType != null && addWordBinding.word1.text.isNotEmpty() && addWordBinding.word2.text.isNotEmpty()) {
            val word = Word(
                0,
                word = addWordBinding.word1.text.toString().toLowerCase().capitalize(),
                translation = addWordBinding.word2.text.toString().toLowerCase().capitalize()
                //typeOfSpeech = TypeOfSpeech.valueOf(selectedType)

            )

            addWordViewModel.insertWord(word)

            findNavController().navigateUp()
        } else {
            Toast.makeText(requireContext(), getString(R.string.missing_data), Toast.LENGTH_SHORT)
                .show()
        }
    }



}