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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adc.puppyadoption.Puppy
import com.example.adc.puppyadoption.fakeData
import com.example.adc.puppyadoption.ui.theme.PuppyAdoptionTheme
import com.example.adc.puppyadoption.ui.theme.blue
import com.example.adc.puppyadoption.ui.theme.red

@Composable
fun PuppyList(puppies: List<Puppy>, onPuppyClick: (Puppy) -> Unit = {}) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppies) { puppy ->
            PuppyItem(
                puppy = puppy,
                modifier = Modifier
                    .clickable { onPuppyClick(puppy) }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, modifier: Modifier = Modifier) {
    val color = if (puppy.isMale) blue else red
    Card(modifier) {
        Row(
            modifier = Modifier.background(color.copy(.08f))
        ) {
            Image(
                painter = painterResource(puppy.picture),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h5,
                    color = color
                )
                Text(puppy.age)
                Text(puppy.location)
            }
        }
    }
}

@Preview
@Composable
fun PuppyListPreview() {
    PuppyAdoptionTheme {
        PuppyList(puppies = fakeData)
    }
}
