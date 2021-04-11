package uk.ac.aber.dcs.cs31620.assignment.mainMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uk.ac.aber.dcs.cs31620.assignment.R

class MainMenu : Fragment() , View.OnClickListener{

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.addWord_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.seeList_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.test_button).setOnClickListener(this)
        view.findViewById<Button>(R.id.changeLanguages_button).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.addWord_button ->navController!!.navigate(
                R.id.action_mainMenu_to_addWord
            )
            R.id.seeList_button ->navController!!.navigate(
                R.id.action_mainMenu_to_seeList
            )
            R.id.test_button ->navController!!.navigate(
                R.id.action_mainMenu_to_tests
            )
            R.id.changeLanguages_button ->navController!!.navigate(
                R.id.action_navigation_mainMenu_to_changeLanguages
            )
        }
    }
}

