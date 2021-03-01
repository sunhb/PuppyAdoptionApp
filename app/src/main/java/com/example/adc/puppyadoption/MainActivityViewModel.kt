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
package com.example.adc.puppyadoption

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val puppies by mutableStateOf(
        fakeData + fakeData // double fake data
    )

    var currentPuppy: Puppy? by mutableStateOf(null)

    fun showPuppy(puppy: Puppy) {
        currentPuppy = puppy
    }

    fun closePuppy() {
        currentPuppy = null
    }
}

data class Puppy(
    val id: String,
    val name: String,
    val gender: String,
    val age: String,
    val breed: String,
    val location: String,
    @DrawableRes val picture: Int,
    val story: String = ""
) {
    val isMale get() = gender == "Male"
}

val puppyForPreview = Puppy(
    id = "9527",
    name = "Teemo",
    gender = "Male",
    age = "3 Years 2 Month",
    breed = "Fake",
    location = "EVA center. #87",
    picture = R.drawable.dog_c,
    story = """
        Teemo throws an explosive poisonous trap using one of the mushrooms stored in his pack. 
        If an enemy steps on the trap, it will release a poisonous cloud, slowing enemies and damaging them over time. 
        If Teemo throws a mushroom onto another mushroom it will bounce, gaining additional range.
    """.trimIndent()
)

val fakeData = listOf(
    Puppy(
        id = "9528",
        name = "Teemo",
        gender = "Male",
        age = "3 Years 2 Month",
        breed = "",
        location = "EVA center. #87",
        picture = R.drawable.dog_a,
        story = """
                    Teemo throws an explosive poisonous trap using one of the mushrooms stored in his pack. 
                    If an enemy steps on the trap, it will release a poisonous cloud, slowing enemies and damaging them over time. 
                    If Teemo throws a mushroom onto another mushroom it will bounce, gaining additional range.
        """.trimIndent()
    ),
    Puppy(
        id = "9529",
        name = "Ludo",
        gender = "Male",
        age = "2 Years 8 Month",
        breed = "Dog",
        location = "EVA Center. #87",
        picture = R.drawable.dog_b,
        story = """
                    When Alexandra returned to Nashville after an off-the-grid yoga and meditation retreat in Colorado, she was surprised to enter the new quarantine world. “I was returning to an empty home, as both my roommates had left town before the lockdowns were enforced,” she says. “The first few weeks were incredibly lonely, not having another living soul in the house with me.” A close friend who was fostering a dog suggested that Alexandra do the same.
                    She started poking around online and discovered Stay Home and Foster, a program that connects foster parents and shelters. Soon, the Nashville Humane Association contacted her and told her about Ludo. Just one look and she was smitten. Now she’s head over heels for new BFF. “Ludo is the sweetest thing!” Alexandra gushes. “She is well-behaved, falls asleep listening to Hiss Golden Messenger and Willie Nelson, and dances listening to Grateful Dead and Tedeschi Trucks Band—just like her new mama. I’m so blessed to have her during this weird time in our history.”
                    By the way, here’s what the experts have to say about whether or not a dog can catch coronavirus.
        """.trimIndent()
    ),
    Puppy(
        id = "9530",
        name = "Anchor",
        gender = "Female",
        age = "1 Years 8 Month",
        breed = "Cat",
        location = "EVA Center. #87",
        picture = R.drawable.cat_a,
        story = """
                    When coronavirus hit, Martina wasn’t quite ready to adopt another pet, since she had recently lost one of her two cats to cancer. Then the unexpected happened. “I had a friend reach out and ask the best place to adopt a kitten, so I took it as a sign that maybe I needed one, too,” says Martina, who lives in Dallas, Texas. That’s when she decided to sign up to be a foster through Stay Home and Foster, and shortly after was contacted by the Humane Society of North Texas to foster Anchor.
                    Anchor has brought new life to Martina and cat sibling Rayna at this doubly difficult time. “She’s my shadow, following me wherever I go, and she makes sure she’s cuddled up in my arms when it’s time to sleep,” Martina explains. “And she’s so loving and playful, which Rayna really appreciates because she thinks she’s a kitten, too.” These 21 before-and-after cat adoption photos will melt your heart.
        """.trimIndent()
    ),
    Puppy(
        id = "9531",
        name = "Lando",
        gender = "Male",
        age = "4 Month",
        breed = "Cat",
        location = "EVA Center. #87",
        picture = R.drawable.cat_c,
        story = """
                    When the Human Society North Texas put out the call for emergency fosters due to the COVID-19 pandemic, Destiny thought it would be a great time to foster a litter of kittens and teach her kids more responsibility. “Little did we know how much we would need them during our shelter-in-place,” says Destiny. “The kittens became a daily source of joy for us during what felt like a Groundhog Day existence. They were growing every day and getting bolder, more active, and more fun!”
                    They fell in love and adopted Lando, a sweet boy born with a slight leg deformity and extra digits on each paw. “He was so cute as he learned to walk on his little bent leg,” notes the proud pet mom. “He never let it stop him from exploring and was the first one to cuddle up next to you.” Brace yourself—here’s a peek at the cutest cat breeds as kittens.
        """.trimIndent()
    ),
    Puppy(
        id = "9532",
        name = "Lime",
        gender = "Male",
        age = "2 Month",
        breed = "Dog",
        location = "EVA Center. #87",
        picture = R.drawable.dog_c,
        story = """
                    When the Human Society North Texas put out the call for emergency fosters due to the COVID-19 pandemic, Destiny thought it would be a great time to foster a litter of kittens and teach her kids more responsibility. “Little did we know how much we would need them during our shelter-in-place,” says Destiny. “The kittens became a daily source of joy for us during what felt like a Groundhog Day existence. They were growing every day and getting bolder, more active, and more fun!”
                    They fell in love and adopted Lando, a sweet boy born with a slight leg deformity and extra digits on each paw. “He was so cute as he learned to walk on his little bent leg,” notes the proud pet mom. “He never let it stop him from exploring and was the first one to cuddle up next to you.” Brace yourself—here’s a peek at the cutest cat breeds as kittens.
        """.trimIndent()
    ),
    Puppy(
        id = "9533",
        name = "Pearl",
        gender = "Female",
        age = "10 Month",
        breed = "Dog",
        location = "EVA Center. #87",
        picture = R.drawable.dog_d,
        story = """
                    Pearl was just one of the adorable hound/lab-mix pups surrendered to a kill shelter, but thankfully her luck improved from there. The Homeward Trails Adoption Center found her a foster home and eventually a fur-ever home with Melissa in Alexandria, Virginia. “Raising and training our six-month-old Pearl during the pandemic has been so rewarding!” Melissa says. “My husband and I are empty-nesters, and this puppy has been a godsend for us!”
                    One of their favorite activities with Pearl is walking. “Having a walk schedule has helped us to have some predictability in our lives during these very unpredictable times,” she says. “It’s also been a good way to ‘see’ neighbors while maintaining a safe distance.” Don’t miss this feel-good story of a woman who fostered not one but two dogs during COVID-19—and why it was the best decision she ever made.
        """.trimIndent()
    ),
    Puppy(
        id = "9534",
        name = "Crusher and McDuff",
        gender = "Male",
        age = "2 Years",
        breed = "Dog",
        location = "EVA Center. #87",
        picture = R.drawable.dog_e,
        story = """
                    Little darlings Crusher and McDuff were suffering from kennel cough when foster mom Tracee Dunblazier first took them in from Hollywood Huskies Rescue. “They were very sick when I received them, and being able to focus on something I could influence for the better was a gift,” says Tracee. “But mostly, the relationship they forged with my Husky, Paloma, was amazing. She took care of them as if they were her own. Paloma was used to spending countless hours at the dog park with other dogs, which stopped completely with the citywide pandemic shutdown. These puppies have given us love, hours of joy, and an opportunity to focus on the things in our life that are life-affirming.” Whether you’re fostering like Tracee or adopting, don’t make 13 puppy training mistakes you’ll regret later.
        """.trimIndent()
    ),
    Puppy(
        id = "9535",
        name = "Sir Chris",
        gender = "Male",
        age = "2 Month",
        breed = "Cat",
        location = "EVA Center. #87",
        picture = R.drawable.cat_d,
        story = """
                    Thanks to Hannah Shaw—aka the Kitten Lady, who works with the Orphan Kitten Club rescue organization—Sir Chris is purr-fectly happy in his new forever home in San Diego, California. When pet parent Sarah saw Sir Chris on the Orphan Kitten Club page, she swooned and immediately applied to adopt him. “Chris is a gift! He has been the silver lining of quarantine,” Sarah says. “Honestly, it has been the best thing to have adopted and brought him into my family during this time.” Sarah was able to get expert advice for introducing Sir Chris to her other cat, Lady Lydia, through the Catology webinar series, which is hosted by Shaw and Royal Canin. “It’s been a huge mental boost to watch the bond grow between Lady Lydia and Sir Chris,” Sarah adds.
        """.trimIndent()
    ),
    Puppy(
        id = "9536",
        name = "Oreo",
        gender = "Male",
        age = "3 Month",
        breed = "Cat",
        location = "EVA Center. #87",
        picture = R.drawable.cat_b,
        story = """
                    Oreo was hardly a “double-stuffed” cat when Shaw (the Kitten Lady) found him. Just three weeks old and in grave health, he needed loving pet parents to nurse him back to health. Enter Aaron and Sabina. They already had an adult cat at home, but they didn’t hesitate to foster this little sweetie. As new foster parents, they were able to take advantage of the educational webinars on Catology, to learn about feline basics such as nutrition, behavior, and socialization.
                    And even though Aaron and Sabina technically saved Oreo, he did some saving of his own, too. “It’s given me a routine back,” Sabina says. “Now we have a job to do, and that is to take care of Oreo.” Aaron is a particularly proud papa because this is the first cat he’s raised from being a kitten. “It has been a special couple of weeks, having this time at home and being able to spend all of it with him and Cake—it’s been amazing!” He adds.
                    
                    These are the 12 telltale signs your cat is happy.
        """.trimIndent()
    ),
    Puppy(
        id = "9537",
        name = "Chancellor",
        gender = "female",
        age = "2 Years 5 Month",
        breed = "Dog",
        location = "EVA Center. #87",
        picture = R.drawable.dog_f,
        story = """
                    Formerly known as Barry, this handsome little guy arrived at the Arizona Humane Society from a partnering animal welfare organization after he came down with parvo, a contagious viral infection. He was treated and nursed back to health, preparing to make his big debut at a signature fundraising event for the group. Meanwhile, Jeremy Thomas, who works on a morning radio show in the area, got wind of Barry’s story and decided to welcome him into his family before anyone else had a chance to fall in love with him. “Bringing Chancellor into our home has helped everyone in our house. He has helped remind us to find joy in the little things during this time because he’s happy all the time,” Jeremy says. “We had two older dogs before we adopted Chancellor, and he has also helped put a pep in their step.”

                    If you’re a new pet parent, there are a few things you have to know. To start, learn which dog vaccinations your puppy really needs.
        """.trimIndent()
    ),
    puppyForPreview
)
