package com.simprints.supermatcher

import com.simprints.supermatcher.data.Candidate
import com.simprints.supermatcher.matcher.SimMatcherImpl
import org.junit.Before
import org.junit.Test

class SimMatcherImplTest {

    private lateinit var SUT : SimMatcherImpl

    @Before
    fun setUp(){
        SUT = SimMatcherImpl()
    }

    @Test
    fun compare_result_matches_expected(){
        val candidate1 = Candidate(0, "Thales", "Lima")
        val candidate2 = Candidate(0, "Fabio", "Tuzza")
        val candidate3 = Candidate(0, "Jeff", "Bezos")
        val candidate4 = Candidate(0, "Elon", "Musk")
        assert(SUT.compareCandidates(candidate3, candidate4) == 16)
        assert(SUT.compareCandidates(candidate1, candidate2) == 27)
    }

    @Test
    fun compare_returns_zero_if_not_char(){
        val candidate1 = Candidate(0, "1111", "2222")
        val candidate2 = Candidate(0, "111%1", "333 ")
        assert(SUT.compareCandidates(candidate1, candidate2) == 0)
    }

    @Test
    fun compare_always_returns_positive(){
        val candidate1 = Candidate(0, "Thales", "Lima")
        val candidate2 = Candidate(0, "Fabio", "Tuzza")
        assert(SUT.compareCandidates(candidate1, candidate2) == 27)
        assert(SUT.compareCandidates(candidate2, candidate1) == 27)
    }
}