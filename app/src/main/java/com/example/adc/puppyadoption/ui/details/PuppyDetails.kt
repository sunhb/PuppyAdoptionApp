package com.example.adc.puppyadoption.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.adc.puppyadoption.Puppy
import com.example.adc.puppyadoption.R
import com.example.adc.puppyadoption.puppyForPreview
import com.example.adc.puppyadoption.ui.components.AnimatingFabContent
import com.example.adc.puppyadoption.ui.components.baselineHeight
import com.example.adc.puppyadoption.ui.theme.PuppyAdoptionTheme
import com.example.adc.puppyadoption.ui.theme.blue
import com.example.adc.puppyadoption.ui.theme.red

@Composable
fun DetailsScreen(puppy: Puppy) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    Header(
                        puppy = puppy,
                        scrollState = scrollState,
                        containerHeight = this@BoxWithConstraints.maxHeight)

                    NameAndLocation(puppy = puppy)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    ) {
                        FieldTag(puppy = puppy, tag = puppy.breed)
                        Spacer(Modifier.width(16.dp))
                        FieldTag(puppy = puppy, tag = puppy.age)
                        Spacer(Modifier.width(16.dp))
                        FieldTag(puppy = puppy, tag = puppy.gender)
                    }
                    Spacer(Modifier.width(24.dp))
                    StoryField(story = puppy.story)

                    Spacer(Modifier.height((this@BoxWithConstraints.maxHeight - 320.dp).coerceAtLeast(0.dp)))
                }
            }
            AdoptFab(
                extended = scrollState.value == 0,
                isMale = puppy.isMale,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
private fun Header(
    puppy: Puppy,
    scrollState: ScrollState,
    containerHeight: Dp
) {
    val offset = scrollState.value / 2
    val offsetDp = with(LocalDensity.current) { offset.toDp() }
    Image(
        painter = painterResource(id = puppy.picture),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        contentDescription = null
    )
}

@Composable
private fun NameAndLocation(puppy: Puppy) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = puppy.name,
            modifier = Modifier.baselineHeight(32.dp),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = puppy.location,
            modifier = Modifier.baselineHeight(24.dp),
            style = MaterialTheme.typography.body1
        )
    }
}


@Composable
fun FieldTag(puppy: Puppy, tag: String) {
    val color = if (puppy.isMale) blue else red
    ChipView(tag = tag, colorResource = color)
}

@Composable
fun ChipView(tag: String, colorResource: Color) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(colorResource.copy(.08f))
    ) {
        Text(
            text = tag, modifier = Modifier.padding(12.dp, 6.dp, 12.dp, 6.dp),
            style = MaterialTheme.typography.caption,
            color = colorResource
        )
    }
}

@Composable
private fun StoryField(story: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = "Story",
                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.subtitle1
            )
        }
        Spacer(Modifier.height(24.dp))
        Text(
            text = story,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun AdoptFab(extended: Boolean, isMale: Boolean, modifier: Modifier = Modifier) {
    key(isMale) {
        FloatingActionButton(
            onClick = { /* TODO */ },
            modifier = modifier
                .padding(16.dp)
                .height(48.dp)
                .widthIn(min = 48.dp),
            backgroundColor = if (isMale) blue else red,
            contentColor = MaterialTheme.colors.onPrimary
        ) {
            AnimatingFabContent(
                icon = {
                    Icon(
                        painterResource(id = R.drawable.adopt),
                        contentDescription = stringResource(id = R.string.adopt)
                    )
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.adopt)
                    )
                },
                extended = extended
            )
        }
    }

}

@Preview
@Composable
fun HeaderPreview() {
    PuppyAdoptionTheme(darkTheme = false) {
        DetailsScreen(puppy = puppyForPreview)
    }
}