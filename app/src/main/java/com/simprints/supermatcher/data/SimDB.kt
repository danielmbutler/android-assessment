package com.simprints.supermatcher.data

import android.os.Parcelable
import com.github.javafaker.Faker
import kotlinx.android.parcel.Parcelize

/**
 * In the Code Review, ignore the methods implementation. It's a simple
 * database mock.
 */
class SimDB {
    private val faker = Faker()

    fun getAllCandidatesFromDatabase(): List<Candidate> = (1..100).map {
        Candidate(
            it,
            faker.name().firstName(),
            faker.name().lastName()
        )
    }
}

@Parcelize
data class Candidate(val id: Int, val name: String, val surname: String) : Parcelable

fun Candidate.getScore(): Int{
    // join first and last name
    val fullName = (this.name + this.surname).replace(" ", "").lowercase()
    var score = 0
    fullName.forEach { currentChar ->
        // only update score if char is letter
        if(Character.isLetter(currentChar)){
            // use Character Arithmetic to get the numerical value of the character
            // the ASCII Value of 'a' is 97, 'b' is 98 etc.
            // e.g. char = 'a' score would be 'a' - 'a' (97-97) which is 0
            // e.g. char = 'b' score would be 'b' - 'a' (98-97) which is 1
            score += currentChar -'a' + 1
        }
    }
    return score
}