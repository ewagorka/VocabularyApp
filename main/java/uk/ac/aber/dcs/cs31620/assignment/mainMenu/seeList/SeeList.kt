package uk.ac.aber.dcs.cs31620.assignment.mainMenu.seeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import uk.ac.aber.dcs.cs31620.assignment.R
import uk.ac.aber.dcs.cs31620.assignment.word.Word
import uk.ac.aber.dcs.cs31620.assignment.word.WordsViewModel
import uk.ac.aber.dcs.cs31620.assignment.databinding.FragmentSeeListBinding

class SeeList : Fragment() {

    private var oldWordList: LiveData<List<Word>>? = null

    private lateinit var seeListBinding: FragmentSeeListBinding
    private lateinit var wordsRecyclerAdapter: SeeListRecyclerWithListAdapter
    private val wordViewModel: WordsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        seeListBinding = FragmentSeeListBinding.inflate(inflater, container, false)

        setupSpinners()
        addWordsRecyclerView()
        addSnackbar()


        return seeListBinding.root
    }

    private fun setupSpinner(view: View?, spinner: Spinner, arrayResourceId: Int) {
        spinner.setSelection(1)

        val adapter =
            ArrayAdapter.createFromResource(
                requireContext(),
                arrayResourceId,
                android.R.layout.simple_spinner_item
            )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val wordList = searchForWords()

                if (oldWordList != wordList) {
                    oldWordList?.removeObservers(viewLifecycleOwner)
                    oldWordList = wordList
                }
                if (!wordList.hasObservers()) {
                    wordList.observe(viewLifecycleOwner) { words ->
                        wordsRecyclerAdapter.changeDataSet(words.toMutableList())
                    }
                }

            }
        }
    }

            private fun searchForWords(): LiveData<List<Word>> {
                val selectedType = seeListBinding.typeOfSpeechSpinner.selectedItem.toString()
                return wordViewModel.getWords(selectedType)
            }

            private fun setupSpinners() {
                setupSpinner(
                    view,
                    seeListBinding.typeOfSpeechSpinner,
                    R.array.type_of_speech_array
                )
            }

            private fun addWordsRecyclerView() {
                val wordList = seeListBinding.wordList
                wordList.setHasFixedSize(true)

                val gridLayoutManager = GridLayoutManager(context, 1)
                wordList.layoutManager = gridLayoutManager

                wordsRecyclerAdapter =
                    SeeListRecyclerWithListAdapter(
                        context
                    )
                wordList.adapter = wordsRecyclerAdapter

                wordsRecyclerAdapter.clickListener = View.OnClickListener { v ->
                    val wordView: TextView = v.findViewById(R.id.wordOriginalTextView)
                    Toast.makeText(context, "Word ${wordView.text} clicked", Toast.LENGTH_SHORT)
                        .show()
                }

            }

            private fun addSnackbar() {
                val fab = seeListBinding.fabAddWord
                fab.setOnClickListener { v ->

                    fab.setOnClickListener {

                        val navController = findNavController()
                        navController.navigate(R.id.action_navigation_seeList_to_navigation_addWord)

                }
            }}





}