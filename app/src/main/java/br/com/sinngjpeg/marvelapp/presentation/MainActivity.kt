package br.com.sinngjpeg.marvelapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.sinngjpeg.marvelapp.R
import br.com.sinngjpeg.marvelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment

        setNavHostFragment(navHostFragment)

        binding.toolbarApp.setupWithNavController(navController, appBarConfiguration)

        removeTopLevelDestinationIcon()
    }

    private fun setNavHostFragment(navHostFragment: NavHostFragment) {
        navController = navHostFragment.navController
        binding.bottomNavMain.setupWithNavController(navController)
        appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.favoritesFragment,
                ),
            )
    }

    private fun removeTopLevelDestinationIcon() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val isTopLevelDestination =
                appBarConfiguration.topLevelDestinations
                    .contains(destination.id)
            if (!isTopLevelDestination) {
                binding.toolbarApp.setNavigationIcon(R.drawable.ic_arrow_back)
            }
        }
    }
}
