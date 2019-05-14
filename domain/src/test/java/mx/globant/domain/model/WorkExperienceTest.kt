package mx.globant.domain.model

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class WorkExperienceTest(
    private val expectedPeriod: String, private val workExperience: WorkExperience
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("Sept 2030 – May 2040", WorkExperience(
                "Developer1", "Globant1", "Ciudad de México",
                "Sept 2030", "May 2040", "Lorem ipsum..."
            )
            ),
            arrayOf("Feb 2012 – Nov 2018", WorkExperience(
                "Developer2", "Globant2", "Ciudad de México",
                "Feb 2012", "Nov 2018", "Lorem ipsum..."
            )
            ),
            arrayOf("March 2003 – Dec 2003", WorkExperience(
                "Developer3", "Globant3", "Ciudad de México",
                "March 2003", "Dec 2003", "Lorem ipsum..."
            )
            )
        )
    }

    @Test
    fun `it should return a period formatted for start and end date`() {
        assertEquals(expectedPeriod, workExperience.getPeriod())
    }
}