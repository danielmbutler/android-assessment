package com.simprints.supermatcher.matcher

import com.simprints.supermatcher.data.Candidate
import com.simprints.supermatcher.data.getScore
import kotlin.math.abs

class SimMatcherImpl : SimMatcher {

    /**
     * This method should return a positive comparison score between candidates.
     *
     * The score is calculated as the difference between the candidate's 'signature'.
     *
     * A ‘signature’ is calculated by summing the values of each character in a candidate’s full name,
     * where a=1, b=2, c=3, and so on. Don't worry about accented characters (á, é), they don't appear.
     *
     * E.g., If a candidate is called “Thales Lima”, his signature will be 100.
     * When compared to a candidate called “Fabio Tuzza” the returned comparison will be 27.
     *
     * The current implementation is a mock version of a matcher.
     *
     * Tasks:
     * - Implement a real matcher based on the description above
     * - Write tests
     */
    override fun compareCandidates(param1: Candidate, param2: Candidate): Int {
        // use abs to always get the absolute difference i.e. a positive number
        return abs(param1.getScore() - param2.getScore())
    }
}