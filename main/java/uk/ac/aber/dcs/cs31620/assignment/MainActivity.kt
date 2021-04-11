package uk.ac.aber.dcs.cs31620.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import uk.ac.aber.dcs.cs31620.assignment.databinding.ActivityMainBinding
import uk.ac.aber.dcs.cs31620.assignment.mainMenu.MainMenu
import uk.ac.aber.dcs.cs31620.assignment.startup.InitializeLanguages


class MainActivity : AppCompatActivity() {

    private val TAG = "StateChange"

    private lateinit var drawer: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var MainMenuFragment: MainMenu
    lateinit var ChangeLanguagesFragment: InitializeLanguages
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navView = findViewById(R.id.nav_view)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        drawer = binding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.nav_open_drawer,
            R.string.nav_close_drawer
        )
        Log.i(TAG, "tu")

        drawer.addDrawerListener(toggle)
        toggle.syncState()

    }

    //Trying to make Navigation Drawer work
    /*binding.navView.setNavigationItemSelectedListener(this)

     MainMenuFragment = MainMenu()
     supportFragmentManager
         .beginTransaction()
         .replace(R.id.nav_host_fragment,MainMenuFragment)
         .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
         .commit()
     Log.i(TAG, "onCreate")*/


  /*  override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_menu -> {
                MainMenuFragment = MainMenu()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, MainMenuFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

        }
        return true
    }*/

}



