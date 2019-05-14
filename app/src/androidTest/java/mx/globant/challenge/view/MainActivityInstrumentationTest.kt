package mx.globant.challenge.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import mx.globant.challenge.R
import org.hamcrest.CoreMatchers.anyOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    @Rule
    @JvmField
    val rule  = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testWorkHistoryPageIsDisplayed_onSwipeLeft() {
        onView(withId(R.id.resumeViewpager))
            .perform(swipeLeft())

        onView(anyOf(withId(R.id.workHistoryRecycler)))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testSkillsPageIsDisplayed_onSwipeLeftTwice() {
        onView(withId(R.id.resumeViewpager))
            .perform(swipeLeft()).perform(swipeLeft())

        onView(anyOf(withId(R.id.skillsRecycler)))
            .check(matches(isDisplayed()))
    }
}