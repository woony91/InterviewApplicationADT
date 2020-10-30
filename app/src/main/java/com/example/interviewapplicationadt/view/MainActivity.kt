package com.example.interviewapplicationadt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.interviewapplicationadt.databinding.ActivityMainBinding
import com.example.interviewapplicationadt.util.ApiState
import com.example.interviewapplicationadt.viewmodel.MainViewModel

/*
Create a sample application to show the list of Characters from the show Rick and Morty.
API Doc: https://rickandmortyapi.com/documentation/#get-all-characters
The application:
• Should fetch the list of characters (https://rickandmortyapi.com/api/character/)
• Should show a scrollable list of those characters including Name, Status, Species and an image of the character
• When a character is clicked, it should show a popup or dialog stating the character’s location Name (location.name)
Optional features:
• Can work both on Landscape (Grid View) and Portrait (Vertical List)
• The list of characters consists of several pages; can implement fetching additional pages of characters as the User scrolls
• Add unit tests
NOTE:
• The code must be shared in GitHub or BitBucket, with frequent commits.
 */
//knaftel@teksystems.com
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}