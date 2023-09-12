package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.widget.CheckBox
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {
    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        // Create a sample Crime object and pass it as an argument to the fragment
        val crime = Crime(
            id = UUID.randomUUID(),
            title = "Test Crime",
            date = Date(),
            isSolved = false
        )
        val bundle = Bundle().apply {
            putSerializable("crime", crime)
        }

        scenario = launchFragmentInContainer(themeResId = R.style.Theme_CriminalIntent)
        scenario.onFragment { fragment ->
            fragment.arguments = bundle
        }
    }

    @Test
    fun checkbox_updates_crime() {
        scenario.onFragment { fragment ->
            // Click the CheckBox to update the crime's solved status
            fragment.view?.findViewById<CheckBox>(R.id.crime_solved)?.performClick()

            // Verify that the CheckBox is checked
            assertTrue(fragment.view?.findViewById<CheckBox>(R.id.crime_solved)?.isChecked == true)

            // Verify that the crime object's state has been updated
            assertTrue(fragment.getCrime().isSolved)
        }
    }
}
