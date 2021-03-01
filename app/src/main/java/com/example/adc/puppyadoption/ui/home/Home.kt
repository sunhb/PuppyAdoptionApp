/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
