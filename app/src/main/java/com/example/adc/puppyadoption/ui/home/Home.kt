package com.example.adc.puppyadoption.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.adc.puppyadoption.MainActivityViewModel
import com.example.adc.puppyadoption.ui.details.DetailsScreen

@Composable
fun Home() {
    val viewModel: MainActivityViewModel = viewModel()
    val currentPuppy = viewModel.currentPuppy
    PuppyList(puppies = viewModel.puppies) { puppy ->
        if (currentPuppy == null) {
            viewModel.showPuppy(puppy)
        }
    }
    if (currentPuppy != null) {
        DetailsScreen(puppy = currentPuppy)
    }
}