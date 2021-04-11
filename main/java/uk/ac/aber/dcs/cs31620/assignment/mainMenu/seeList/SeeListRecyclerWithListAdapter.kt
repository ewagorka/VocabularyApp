package uk.ac.aber.dcs.cs31620.assignment.mainMenu.seeList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import uk.ac.aber.dcs.cs31620.assignment.word.Word
import uk.ac.aber.dcs.cs31620.assignment.databinding.WordItemBinding

class SeeListRecyclerWithListAdapter(
    private val context: Context?
):
    RecyclerView.Adapter<SeeListRecyclerWithListAdapter.ViewHolder>(){
    private var dataSet: MutableList<Word> = mutableListOf() // Empty word list
    var clickListener: View.OnClickListener?=null

    inner class ViewHolder(
        itemView: View,
        val originalWordView: TextView,
        val translationWordView: TextView,
        val typeOfSpeechWordView: TextView
    ):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(clickListener)
        }

        fun bindDataSet(word: Word) {
            originalWordView.text = word.word
            translationWordView.text = word.translation
          //  typeOfSpeechWordView.text = word.typeOfSpeech.toString().toLowerCase()


        }
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val wordItemBinding = WordItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(
            wordItemBinding.wordCard,
            wordItemBinding.wordOriginalTextView,
            wordItemBinding.wordTranslationTextView,
            wordItemBinding.typeOfSpeechTextView

        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindDataSet(dataSet[position])
    }

    fun changeDataSet(dataSet: MutableList<Word>){
    this.dataSet = dataSet
        this.notifyDataSetChanged()
    }
}