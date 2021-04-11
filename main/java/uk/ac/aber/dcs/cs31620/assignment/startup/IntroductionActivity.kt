package uk.ac.aber.dcs.cs31620.assignment.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uk.ac.aber.dcs.cs31620.assignment.R

class IntroductionActivity : Fragment() , View.OnClickListener {
    lateinit var navController: NavController
      var show: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_introduction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.submitLanguagesButton).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.submitLanguagesButton -> navController!!.navigate(
                R.id.action_introductionActivity_to_navigation_mainMenu
            )
        }
    }
    }